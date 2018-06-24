package com.esi.tdm.apetito.Dish

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.esi.tdm.apetito.Entity.Category
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.config.imageBaseUrl
import com.esi.tdm.apetito.Entity.Dish
import com.esi.tdm.apetito.utlis.Utils
import kotlinx.android.synthetic.main.fragment_category_dishes.*
import kotlinx.android.synthetic.main.fragment_dish_infos.*
import org.jetbrains.anko.toast

class DishInfoActivity() : AppCompatActivity() {

    var position:Int = 0
    lateinit var category: Category
    lateinit var dish : Dish
    var list = mutableListOf<Dish>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_info)


        dish= intent.getSerializableExtra("dish") as Dish
        category = intent.getSerializableExtra("category") as Category
        if (dish.imageUrl == null){
            dish.imageUrl = "salade/salade1.png"
        }
        Glide.with(this).load(imageBaseUrl + dish.imageUrl)
                .into(dishImage)
        dishPriceDetail.setText(dish.price.toString())
        dishNameDetail.setText(dish.name)
        dishDescription.setText(dish.description)
        CategoryDishesName.setText(category.name)
        var utils = Utils()
//        when(categorie){
//            -1->{
//                dishImage.setImageResource(R.drawable.lunch)
//                dishPriceDetail.setText("2500")
//                dishNameDetail.setText("Saumon Royale")
//                dishDescription.setText(resources.getString(R.string.dishDescription))
//            }
//            0->{
//                list = utils.populateDishesEntries(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//
//            }
//            1->{
//                list = utils.populateDishesPlats(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//            }
//            2->{
//                list = utils.populateDishesDrinks(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//            }
//            3->{
//                list = utils.populateDishesDesserts(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//            }
//            4->{
//                list = utils.populateDishesVege(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//            }
//            5->{
//                list = utils.populateDishesDiab(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//            }
//            6->{
//                list = utils.populateDishes(this) as MutableList<Dish>
//                dishImage.setImageResource(list.get(position).listImage)
//                dishPriceDetail.setText(list.get(position).price.toString())
//                dishNameDetail.setText(list.get(position).name)
//                dishDescription.setText(list.get(position).description)
//            }
//        }

    }
}
