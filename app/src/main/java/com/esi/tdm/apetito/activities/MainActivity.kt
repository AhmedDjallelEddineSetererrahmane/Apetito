package com.esi.tdm.apetito.activities

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        var utlis = Utils()

        var restosAdapter = RestaurantAdapter(this,utlis.populateRestosData(7))
        restaurantList.adapter = restosAdapter

        //OnClick

        restaurantList.setOnItemClickListener{adapterView,view,i,l ->
            startActivity(intentFor<RestaurantActivity>("pos" to i))
        }
    }

}
