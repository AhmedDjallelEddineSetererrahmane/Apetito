package example.android.com.dataserverpersistance.viewmodel

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.nfc.Tag
import android.util.Log
import android.view.View

import android.widget.ListView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.esi.tdm.apetito.Category.CategoryAdpater
import com.esi.tdm.apetito.Database.RoomService
import com.esi.tdm.apetito.Entity.Category
import com.esi.tdm.apetito.R

import com.esi.tdm.apetito.config.imageBaseUrl
import com.esi.tdm.apetito.retrofit.RetrofitService
import kotlinx.android.synthetic.main.categorie_item_layout.*
import kotlinx.android.synthetic.main.fragment_categories.*

import kotlinx.android.synthetic.main.restaurant_layout.*

import org.jetbrains.anko.toast


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CategoryViewModel:ViewModel() {

//    lateinit var progressBarCategory : ProgressBar
    var category:Category? = null
     var categories:List<Category>? =null
    lateinit var listView : ListView
    fun loadData(act:Activity, listView: ListView ) {

//        progressBarCategory = act.findViewById(R.id.progressBarCategory)
//        progressBarCategory.visibility = View.VISIBLE
        // Get cities from SQLite DB
        val db = RoomService.getInstance(act)

        categories = db?.getCategoryDao()?.getCategories()
        RoomService.destroyInstance()

        if (categories?.size == 0) {
            act.toast("raha null...")

            getListFromRemote(act, listView)
        }
        else {
//               progressBarCategory.visibility = View.GONE

               listView.adapter = CategoryAdpater(act, categories!!)
        }

    }


    private fun getListFromRemote(act:Activity , listView: ListView) {
        act.toast("FETCHING...")
        val call = RetrofitService.CategoryEndpoint.getCategories()
        call.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>?) {

//                progressBarCategory.visibility = View.GONE
                act.toast("Before ...")
                if (response?.isSuccessful!!) {
                    categories = response?.body()
                    act.toast(category.toString())
//                    progressBarCategory.visibility = View.GONE
                    listView.adapter = CategoryAdpater(act, categories!!)
                    val db = RoomService.getInstance(act)
                    db?.getCategoryDao()?.addCategories(categories!! )
                    RoomService.destroyInstance()
                } else {
                    act.toast("Une erreur s'est produite")
                }
            }

            override fun onFailure(call: Call<List<Category>>?, t: Throwable?) {

//                 progressBarCategory.visibility = View.GONE

                act.toast(t.toString())
                act.toast("Une erreur est produite")
            }


        })
    }

//    fun loadDetail(act:Activity, category: Category) {
//
//        //act.progressBarRestaurant2.visibility = View.VISIBLE
//        // load city detail from SQLite DB
//        this.category = RoomService.getInstance(act)?.getCategoryDao()?.getCategoryById(category.idCategory)
//        if(this.category?.imageUrl==null) {
//            // if the city details don't exist, load the details from server and update SQLite DB
//            loadDetailFromRemote(act,category)
//        }
//        else {
//            //act.progressBarRestaurant2.visibility = View.GONE
//            displayDatail(act, this.category!!)
//        }
//    }
//
//    private fun loadDetailFromRemote(act:Activity,category: Category) {
//        val call = RetrofitService.CategoryEndpoint.getCategory(category.idCategory)
//        call.enqueue(object : Callback<Category> {
//            override fun onResponse(call: Call<Category>?, response: Response<Category>?) {
//                //act.progressBarRestaurant2.visibility = View.GONE
//                if(response?.isSuccessful!!) {
//                    var categoryDetail = response?.body() as Category
//
//                    displayDatail(act,categoryDetail)
//                    // update the city in the SQLite DB to support offline mode
//                    RoomService.getInstance(act)?.getCategoryDao()?.updateCategory(categoryDetail)
//                    // update ViewModel
//                    this@CategoryViewModel.category = categoryDetail
//                }
//                else {
//                    act.toast("Une erreur s'est produite")
//                }
//            }
//            override fun onFailure(call: Call<Category>?, t: Throwable?) {
//                //act.progressBarRestaurant2.visibility = View.GONE
//                act.toast("Une erreur s'est produite")
//
//            }
//        })
//    }
//
//    fun displayDatail(act: Activity,category: Category) {
//        Glide.with(act).load(imageBaseUrl + category.imageUrl)
//                .into(act.restaurantImage)
//        act.categoryName?.text = category.name
//
//    }


}