package com.esi.tdm.apetito.activities

import android.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.esi.tdm.apetito.Entity.Restaurant
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.Adapter.RestaurantAdapter
import com.esi.tdm.apetito.utlis.Utils
import example.android.com.dataserverpersistance.viewmodel.RestaurantViewModel

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var utils = Utils()

//        var restosAdapter = RestaurantAdapter(this,utils.populateRestosData(this))
//        restaurantList.adapter = restosAdapter
//
//        //OnClick
//        restaurantList.setOnItemClickListener{adapterView,view,i,l ->
//            if (isTwoPane()){
//
//            }
//            else{
//                startActivity(intentFor<RestaurantActivity>("pos" to i))
//            }
//        }
        // View Model instance
        val restaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel::class.java)
        // If the list of cities is null, load the list from DB
        if (restaurantViewModel.restaurants==null) {
            restaurantViewModel.loadData(this)
        }
        else {
            // After the rotation of the screen, use cities of the ViewModel instance
            restaurantList.adapter = RestaurantAdapter(this, restaurantViewModel.restaurants!!)
        }

        // Display detail data if width >= 600 dp

        if (isTwoPane() && restaurantViewModel.restaurant!=null) {
            restaurantViewModel.displayDatail(this,restaurantViewModel.restaurant!!)

        }

        // ListView OnClick Item

        restaurantList.setOnItemClickListener { adapterView, view, i, l ->
            val restaurant = (adapterView.getItemAtPosition(i) as Restaurant)
            if (isTwoPane()) {
                // display detail data
                restaurantViewModel.loadDetail(this,restaurant)
            }
            else {
                startActivity(intentFor<RestaurantActivity>("restaurant" to restaurant))
            }
        }
    }

    fun isTwoPane() = findViewById<View>(R.id.fragment3) != null

}
