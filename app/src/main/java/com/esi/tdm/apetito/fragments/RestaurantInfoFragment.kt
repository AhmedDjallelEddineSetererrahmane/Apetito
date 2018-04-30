package com.esi.tdm.apetito.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Position
import com.esi.tdm.apetito.utlis.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import org.jetbrains.anko.support.v4.email
import org.jetbrains.anko.support.v4.makeCall


@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class RestaurantInfoFragment(position: Int) : Fragment() ,OnMapReadyCallback{


    var position = position
    var restaurantImages = arrayOf(R.drawable.resto_1,R.drawable.resto_2,R.drawable.resto_3)
    var geo = Position(0.0,0.0)
    private lateinit var mMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view  = inflater!!.inflate(R.layout.fragment_restaurant_info, container, false)
        var carouselView = view.findViewById<CarouselView>(R.id.restoCarousel) as CarouselView
        carouselView.pageCount = restaurantImages.size
        carouselView.setImageListener(imageListener)
        var utils = Utils()
        var list = utils.populateRestosData(activity!!)


        var restoName = view.findViewById<TextView>(R.id.restoName) as TextView
        var restoADR1  = view.findViewById<TextView>(R.id.restoADR1) as TextView
        var restoRate = view.findViewById<TextView>(R.id.restoRate) as TextView

        restoName.setText(list[position].name)
        restoADR1.setText(list[position].adr)
        restoRate.setText(list[position].rating.toString())
        var facebook = view.findViewById<ImageView>(R.id.facebook) as ImageView
        var twitter = view.findViewById<ImageView>(R.id.twitter) as ImageView
        var email = view.findViewById<TextView>(R.id.email) as TextView
        var phone = view.findViewById<TextView>(R.id.phoneNumber) as TextView


        val facebookUrl  = "fb://page/218641444910278"
        var twitterUrl = "twitter://user?user_id=382267114"
        facebook.setOnClickListener(View.OnClickListener {
            activity?.let { it1 -> utils.openFacebookPage(it1,facebookUrl) }
        })
        twitter.setOnClickListener(View.OnClickListener {
            activity?.let { it1 -> utils.openTwitterPage(it1,twitterUrl) }
        })

        phone.setOnClickListener(View.OnClickListener {
            makeCall(phone.text.toString())
        })
        email.setOnClickListener(View.OnClickListener {
            email(email.text.toString(),"Commande","")
        })

         geo = list[position].geoPosition

        val mapFragment = childFragmentManager
                .findFragmentById(R.id.map1) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }
    var imageListener = ImageListener{position, imageView ->
        imageView.setImageResource(restaurantImages[position])
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(geo.latitude, geo.longitude)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}// Required empty public constructor
