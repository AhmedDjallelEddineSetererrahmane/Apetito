package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.esi.tdm.apetito.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_restaurant_info.*
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 */
class RestaurantInfoFragment : Fragment() {


    var restaurantImages = arrayOf(R.drawable.resto_1,R.drawable.resto_2,R.drawable.resto_3)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view  = inflater!!.inflate(R.layout.fragment_restaurant_info, container, false)
        var carouselView = view.findViewById<CarouselView>(R.id.restoCarousel) as CarouselView
        carouselView.pageCount = restaurantImages.size
        carouselView.setImageListener(imageListener)
        var facebook = view.findViewById<ImageView>(R.id.facebook) as ImageView
        var twitter = view.findViewById<ImageView>(R.id.twitter) as ImageView

        facebook.setOnClickListener(View.OnClickListener {
            toast("facebook")
        })
        twitter.setOnClickListener(View.OnClickListener {
            toast("twitter")
        })
        return view
    }
    var imageListener = ImageListener{position, imageView ->
        imageView.setImageResource(restaurantImages[position])
    }
}// Required empty public constructor
