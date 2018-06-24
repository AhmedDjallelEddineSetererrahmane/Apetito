package example.android.com.dataserverpersistance.viewmodel

import android.app.Activity
import android.arch.lifecycle.ViewModel

import android.widget.ListView
import android.widget.ProgressBar
import com.esi.tdm.apetito.Adapter.DishAdapter
import com.esi.tdm.apetito.Database.RoomService
import com.esi.tdm.apetito.Entity.Dish
import com.esi.tdm.apetito.retrofit.RetrofitService
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class DishViewModel:ViewModel() {


    lateinit var progressBarDish : ProgressBar
    var dish:Dish? = null
    var dishes:List<Dish>? =null
    var EntryDishes:List<Dish>? =null
    var VegeDishes:List<Dish>? =null
    var DiabiticDishes:List<Dish>? =null
    var PrincipalDishes:List<Dish>? =null
    var dessertDishes:List<Dish>? =null
    var drinkDishes:List<Dish>? =null
    lateinit var listView : ListView
    fun loadData(act:Activity, listView: ListView ) {
//        progressBarDish = act.findViewById<ProgressBar>(R.id.progressBarDish)
//        progressBarDish.visibility = View.VISIBLE
        // Get cities from SQLite DB
        val db = RoomService.getInstance(act)

        dishes = db?.getDishDao()?.getDishes()
        RoomService.destroyInstance()

        if (dishes?.size == 0) {
            act.toast("raha null...")

            getListFromRemote(act, listView)
        }
        else {
//            progressBarDish.visibility = View.GONE
            listView.adapter = DishAdapter(act, dishes!!)
        }

    }


    private fun getListFromRemote(act:Activity , listView: ListView) {
        act.toast("FETCHING...")

        val call = RetrofitService.DishEndpoint.getDishesByCategory("5b2e050ca669da1001e692b4")
        call.enqueue(object : Callback<List<Dish>> {
            override fun onResponse(call: Call<List<Dish>>?, response: Response<List<Dish>>?) {

//                progressBarDish.visibility = View.GONE
                act.toast("Before ...")
                if (response?.isSuccessful!!) {
                    dishes = response?.body()
                    //act.toast(dishes!!.size)
//                    progressBarDish.visibility = View.GONE
                    listView.adapter = DishAdapter(act, dishes!!)
                    val db = RoomService.getInstance(act)
                    db?.getDishDao()?.addDishes(dishes!!)
                    RoomService.destroyInstance()
                } else {
                    act.toast("Une erreur s'est produite")
                }
            }

            override fun onFailure(call: Call<List<Dish>>?, t: Throwable?) {

//                progressBarDish.visibility = View.GONE

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