package com.esi.tdm.apetito.helpers

import android.arch.lifecycle.ViewModel
import com.esi.tdm.apetito.activities.RestaurantActivity
import com.esi.tdm.apetito.models.Restaurant

/**
 * Created by djall on 4/27/2018.
 */
class RestaurantModel: ViewModel() {
    var restaurant:Restaurant = Restaurant()
}