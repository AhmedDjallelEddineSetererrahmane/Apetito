package com.esi.tdm.apetito.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.Entity.Restaurant
import com.esi.tdm.apetito.config.imageBaseUrl
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
class RestaurantInfoFragment(restaurant: Restaurant) : Fragment() ,OnMapReadyCallback{


    var _ctx = this
    var position = restaurant.position
    var restaurant = restaurant
    var restaurantImages = arrayOf(restaurant.imageUrl,restaurant.imageUrl2,restaurant.imageUrl3)
    var geo = arrayOf(restaurant.latitude , restaurant.longitude)
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
        var restoDescription = view.findViewById<TextView>(R.id.restoDescription) as TextView


        restoName.setText(restaurant.name)
        restoADR1.setText(restaurant.adr)
        restoRate.setText(restaurant.rating.toString())
        restoDescription.setText(restaurant.description)

        var facebook = view.findViewById<ImageView>(R.id.facebook) as ImageView
        var twitter = view.findViewById<ImageView>(R.id.twitter) as ImageView
        var email = view.findViewById<TextView>(R.id.email) as TextView
        var phone = view.findViewById<TextView>(R.id.phoneNumber) as TextView


        val facebookUrl  = restaurant.facebookUrl
        var twitterUrl = restaurant.twitterUrl
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



        val mapFragment = childFragmentManager
                .findFragmentById(R.id.map1) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }
    var imageListener = ImageListener{position, imageView ->
        Glide.with(_ctx).load(imageBaseUrl + restaurantImages[position])
                .into(imageView)
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(geo[0], geo[1])
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}// Required empty public constructor
