package example.android.com.dataserverpersistance.viewmodel

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.esi.tdm.apetito.Database.RoomService
import com.esi.tdm.apetito.Entity.Restaurant
import com.esi.tdm.apetito.Adapter.RestaurantAdapter
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.RestaurantActivity
import com.esi.tdm.apetito.retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class RestaurantViewModel:ViewModel() {


    var restaurant: Restaurant? = null
    var restaurants:List<Restaurant>? = null

    fun loadData(act:Activity) {
        act.progressBarRestaurant.visibility = View.VISIBLE
        // Get cities from SQLite DB
        val db = RoomService.getInstance(act)

        restaurants = db?.getRestaurantDao()?.getRestaurants()
        if (restaurants?.size == 0) {
            // If the list of cities is empty, load from server and save them in SQLite DB
            getRestaurantsFromRemote(act)
        }
        else {
            act.progressBarRestaurant.visibility = View.GONE
            act.restaurantList.adapter = RestaurantAdapter(act, restaurants!!)
        }

    }

    private fun getRestaurantsFromRemote(act:Activity ) {
//        Log.d("FETCH","begin fetching ...")
//        val call = RetrofitService.RestaurantEndpoint.getRestaurants()
//        call.enqueue(object : Callback<List<Restaurant>> {
//            override fun onResponse(call: Call<List<Restaurant>>?, response: Response<List<Restaurant>>?) {
//                act.progressBarRestaurant.visibility = View.GONE
//                if (response?.isSuccessful!!) {
//                    restaurants = response?.body()
//                    Log.d("FETCH",restaurants.toString())
//                    act.progressBarRestaurant.visibility = View.GONE
//                    act.restaurantList.adapter = RestaurantAdapter(act, restaurants!!)
//                    // save cities in SQLite DB
//                    val db = RoomService.getInstance(act)
//
//                    restaurants = db?.getRestaurantDao()?.getRestaurants()
//                } else {
//                    act.toast("Une erreur s'est produite")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Restaurant>>?, t: Throwable?) {
//                act.progressBarRestaurant.visibility = View.GONE
//                act.toast("Une erreur s'est produite")
//            }
//
//
//        })
    }

    fun loadDetail(act:Activity, restaurant: Restaurant) {


    }

    private fun loadDetailFromRemote(act:Activity,restaurant: Restaurant) {

    }

    fun displayDatail(act: Activity,restaurant: Restaurant) {

    }


}