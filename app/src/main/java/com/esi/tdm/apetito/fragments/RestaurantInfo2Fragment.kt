package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.RestaurantActivity
import com.esi.tdm.apetito.utlis.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.fragment_restaurant_info.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.email
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.makeCall
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 */
class RestaurantInfo2Fragment : Fragment() ,OnMapReadyCallback{


    var restaurantImages = arrayOf(R.drawable.resto_1,R.drawable.resto_2,R.drawable.resto_3)
    private lateinit var mMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view  = inflater!!.inflate(R.layout.fragment_restaurant_info2, container, false)
        var carouselView = view.findViewById<CarouselView>(R.id.restoCarousel) as CarouselView
        carouselView.pageCount = restaurantImages.size
        carouselView.setImageListener(imageListener)
        var facebook = view.findViewById<ImageView>(R.id.facebook) as ImageView
        var twitter = view.findViewById<ImageView>(R.id.twitter) as ImageView
        var email = view.findViewById<TextView>(R.id.email) as TextView
        var phone = view.findViewById<TextView>(R.id.phoneNumber) as TextView
        var open = view.findViewById<ImageView>(R.id.openResto) as ImageView


        var utils = Utils()
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

        open.setOnClickListener(View.OnClickListener {
            startActivity(intentFor<RestaurantActivity>())

        })

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
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}// Required empty public constructor
