package com.esi.tdm.apetito.activities

import android.app.Fragment
import android.content.Context
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.adapters.RestaurantAdapter
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.utlis.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_dish_infos.*
import kotlinx.android.synthetic.main.fragment_restaurant_info2.*
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
                displayDetail(this,i)
            }
            else{
                startActivity(intentFor<RestaurantActivity>("pos" to i))
            }
        }
    }

    fun isTwoPane() = findViewById<View>(R.id.fragment3) != null

    fun displayDetail(_ctx: Context, i:Int){
        var utils = Utils()
        var list = utils.populateRestosData(_ctx)


        var restoName = findViewById<TextView>(R.id.nameN) as TextView
        var restoADR1  =findViewById<TextView>(R.id.adradr) as TextView
        var rating  =findViewById<TextView>(R.id.ratingr) as TextView

        restoName.setText(list[i].name)
        restoADR1.setText(list[i].adr)
        rating.setText(list[i].rating.toString())
    }
}
