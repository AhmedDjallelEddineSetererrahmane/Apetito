package com.esi.tdm.apetito.Restaurant

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.esi.tdm.apetito.Category.CategoriesFragment
import com.esi.tdm.apetito.Entity.Restaurant
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.fragments.*
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.app_bar_restaurant.*

class RestaurantActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var position = 0
    lateinit var restaurant :Restaurant
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        setSupportActionBar(toolbar)
        restaurant= intent.getSerializableExtra("restaurant") as Restaurant
        //fab.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //.setAction("Action", null).show()
        //}

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()




        supportFragmentManager.beginTransaction()
                .replace(R.id.mainFrame, RestaurantInfoFragment(restaurant))
                .commit()
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.restaurant, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, RestaurantInfoFragment(restaurant))
                        .commit()
            }
            R.id.categorie -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, CategoriesFragment())
                        .commit()
            }
            R.id.allDishes -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,AllDishesFragment())
                        .commit()
            }
            R.id.binary -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,BinaryFragment())
                        .commit()
            }
            R.id.basket -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,MyBasketFragment())
                        .commit()
            }
            R.id.reserv -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,bookingFragment())
                        .commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
