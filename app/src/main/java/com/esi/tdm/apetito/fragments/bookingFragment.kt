package com.esi.tdm.apetito.fragments


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.adapters.ReservationAdapter
import com.esi.tdm.apetito.models.Reservation
import com.esi.tdm.apetito.models.ReservationItems
import org.jetbrains.anko.db.NULL
import org.jetbrains.anko.support.v4.toast
import java.sql.Time
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class bookingFragment : Fragment() {


    var mDatePickerDialog: DatePickerDialog? = null
    var mHourDialog:TimePickerDialog?=null
    var reservDate:Date? = null
    var reservHour:Time? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_booking, container, false)

        var list = view.findViewById<ListView>(R.id.reservations) as ListView
        var adapter = ReservationAdapter(activity!!,ReservationItems.list)
        list.adapter = adapter
            Log.e("here","here")
            var fab = view.findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton
            fab.setOnClickListener(View.OnClickListener {
                activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,DoBookingFragment())
                        .commit()
            })

        return view
    }

    fun isTwoPan() = activity?.findViewById<View>(R.id.fragment11) ==null



}// Required empty public constructor
