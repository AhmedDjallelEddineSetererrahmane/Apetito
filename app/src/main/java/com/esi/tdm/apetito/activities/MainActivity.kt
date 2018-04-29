package com.esi.tdm.apetito.activities

import android.app.Fragment
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.adapters.RestaurantAdapter
import com.esi.tdm.apetito.utlis.Utils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var utils = Utils()

        var restosAdapter = RestaurantAdapter(this,utils.populateRestosData(this))
        restaurantList.adapter = restosAdapter

        //OnClick


        restaurantList.setOnItemClickListener{adapterView,view,i,l ->
            if (isTwoPane()){

            }
            else{
                startActivity(intentFor<RestaurantActivity>("pos" to i))
            }
        }
    }

    fun isTwoPane() = findViewById<View>(R.id.fragment3) != null

}
