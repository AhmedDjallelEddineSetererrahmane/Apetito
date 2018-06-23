package example.android.com.dataserverpersistance.viewmodel

import android.app.Activity
import android.app.Fragment
import android.arch.lifecycle.ViewModel
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.esi.tdm.apetito.Database.RoomService
import com.esi.tdm.apetito.Entity.Restaurant
import com.esi.tdm.apetito.Adapter.RestaurantAdapter
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.RestaurantActivity
import com.esi.tdm.apetito.config.baseUrl
import com.esi.tdm.apetito.config.imageBaseUrl
import com.esi.tdm.apetito.retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_restaurant_info.*
import kotlinx.android.synthetic.main.restaurant_layout.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

import org.jetbrains.anko.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class RestaurantViewModel:ViewModel() {


    var restaurant: Restaurant? = null
    var restaurants:List<Restaurant>? = null
    lateinit var listView : ListView
    fun loadData(act:Activity , isTwoPane : Boolean, listView: ListView) {
//        act.progressBarRestaurant.visibility = View.VISIBLE
        // Get cities from SQLite DB
        val db = RoomService.getInstance(act)

        restaurants = db?.getRestaurantDao()?.getRestaurants()
        RoomService.destroyInstance()

        if (restaurants?.size == 0) {
            // If the list of cities is empty, load from server and save them in SQLite DB
            getRestaurantsFromRemote(act,isTwoPane,listView)
        }
        else {
//            act.progressBarRestaurant.visibility = View.GONE
            if (isTwoPane) {
                listView.adapter = RestaurantAdapter(act, restaurants!!)
            }else{
               listView.adapter = RestaurantAdapter(act, restaurants!!)
            }
        }

    }


    private fun getRestaurantsFromRemote(act:Activity, isTwoPane : Boolean ,listView: ListView) {
        act.toast("FETCHING...")
        val call = RetrofitService.RestaurantEndpoint.getRestaurants()
        call.enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(call: Call<List<Restaurant>>?, response: Response<List<Restaurant>>?) {

//                act.progressBarRestaurant.visibility = View.GONE
                act.toast("Before ...")
                if (response?.isSuccessful!!) {
                    restaurants = response?.body()
                    act.toast(restaurant.toString())
//                    act.progressBarRestaurant.visibility = View.GONE
                    if (isTwoPane) {
                        listView.adapter = RestaurantAdapter(act, restaurants!!)
                    }else{
                        listView.adapter = RestaurantAdapter(act, restaurants!!)
                    }
                    // save cities in SQLite DB
                    val db = RoomService.getInstance(act)

                    restaurants = db?.getRestaurantDao()?.getRestaurants()
                    RoomService.destroyInstance()
                } else {
                    act.toast("Une erreur s'est produite")
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>?, t: Throwable?) {
                if (isTwoPane) {
//                    act.fragment2.progressBarRestaurant2.visibility = View.GONE

                }else{
//                    act.progressBarRestaurant.visibility = View.GONE

                }
                act.toast(t.toString())
               // act.toast("Une erreur est produite")
            }


        })
    }

    fun loadDetail(act:Activity, restaurant: Restaurant) {

        act.progressBarRestaurant2.visibility = View.VISIBLE
        // load city detail from SQLite DB
        this.restaurant = RoomService.getInstance(act)?.getRestaurantDao()?.getRestaurantById(restaurant.idRestaurant)
        if(this.restaurant?.listImage==null) {
            // if the city details don't exist, load the details from server and update SQLite DB
            loadDetailFromRemote(act,restaurant)
        }
        else {
            act.progressBarRestaurant2.visibility = View.GONE
            displayDatail(act, this.restaurant!!)
        }
    }

    private fun loadDetailFromRemote(act:Activity,restaurant: Restaurant) {
        val call = RetrofitService.RestaurantEndpoint.getRestaurant(restaurant.idRestaurant)
        call.enqueue(object : Callback<Restaurant> {
            override fun onResponse(call: Call<Restaurant>?, response: Response<Restaurant>?) {
                act.progressBarRestaurant2.visibility = View.GONE
                if(response?.isSuccessful!!) {
                    var restaurantDetail = response?.body() as Restaurant

                    displayDatail(act,restaurantDetail)
                    // update the city in the SQLite DB to support offline mode
                    RoomService.getInstance(act)?.getRestaurantDao()?.updateRestaurant(restaurantDetail)
                    // update ViewModel
                    this@RestaurantViewModel.restaurant = restaurantDetail

                }
                else {
                    act.toast("Une erreur s'est produite")

                }

            }

            override fun onFailure(call: Call<Restaurant>?, t: Throwable?) {
                act.progressBarRestaurant2.visibility = View.GONE
                act.toast("Une erreur s'est produite")

            }
        })
    }

    fun displayDatail(act: Activity,restaurant: Restaurant) {
        Glide.with(act).load(imageBaseUrl + restaurant.imageUrl)
                .into(act.restaurantImage)

        act.restaurantName?.text = restaurant.name
        act.restaurantAdr?.text = restaurant.adr
        act.restaurantOpening?.text = restaurant.openingHour
        act.rating?.text = restaurant.rating.toString()
        act.restoDescription?.text = restaurant.description

    }


}