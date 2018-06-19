package com.esi.tdm.apetito.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Binary
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.utlis.Utils
import kotlinx.android.synthetic.main.fragment_binary_dish_infos.*

class binaryDishInfo : AppCompatActivity() {


    var position:Int = 0
    var categorie:Int = 0
    var list = mutableListOf<Binary>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_dish_info)

        position = intent.getIntExtra("index",0)
        categorie = intent.getIntExtra("position",0)

        var utils = Utils()
        list = utils.populateDishesBinary(this) as MutableList<Binary>

        dishName1a.setText(list.get(position).dish1.name)
        dishName2a.setText(list.get(position).dish2.name)
        dishImageList1a.setImageResource(list.get(position).dish1.listImage)
        dishImageList2a.setImageResource(list.get(position).dish2.listImage)


    }
}
