package com.esi.tdm.apetito.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.CartItem
import com.esi.tdm.apetito.models.CartItems
import kotlinx.android.synthetic.main.activity_order.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        orderNow.setOnClickListener(View.OnClickListener {
            toast("Commander avec succes , Merci !")
            CartItems.list = mutableListOf<CartItem>()
            startActivity(intentFor<MainActivity>())

        })



    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
