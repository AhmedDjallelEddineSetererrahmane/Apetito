package com.esi.tdm.apetito.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.esi.tdm.apetito.R
import org.jetbrains.anko.toast

class DishInfoActivity : AppCompatActivity() {

    var position:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_info)

        position = intent.getIntExtra("index",0)
        toast(position.toString())
    }
}
