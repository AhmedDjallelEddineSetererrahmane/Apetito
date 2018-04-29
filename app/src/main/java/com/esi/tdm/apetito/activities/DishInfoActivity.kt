package com.esi.tdm.apetito.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.utlis.Utils
import kotlinx.android.synthetic.main.fragment_dish_infos.*
import org.jetbrains.anko.toast

class DishInfoActivity : AppCompatActivity() {

    var position:Int = 0
    var categorie:Int = 0
    var list = mutableListOf<Dish>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_info)

        position = intent.getIntExtra("index",0)
        categorie = intent.getIntExtra("categorie",0)
        var utils = Utils()
        when(categorie){
            0->{
                list = utils.populateDishesEntries(this) as MutableList<Dish>
                dishImage.setImageResource(list.get(position).listImage)
                dishPriceDetail.setText(list.get(position).price.toString())
                dishNameDetail.setText(list.get(position).name)
                dishDescription.setText(list.get(position).description)

            }
            1->{
            }
            2->{

            }
            3->{

            }
            4->{

            }
            5->{

            }
        }

    }
}
