package com.esi.tdm.apetito.fragments


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Reservation
import com.esi.tdm.apetito.models.ReservationItems
import org.jetbrains.anko.support.v4.toast
import java.sql.Time
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class DoBookingFragment : Fragment() {


    var mDatePickerDialog: DatePickerDialog? = null
    var mHourDialog: TimePickerDialog?=null
    var reservDate: Date? = null
    var reservHour: Time? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_do_booking, container, false)
        var selectDate = view.findViewById<EditText>(R.id.reserveDate) as EditText
        var selectHour = view.findViewById<EditText>(R.id.reservHour) as EditText
        var nbPr = view.findViewById<EditText>(R.id.nbPresson) as EditText

        var submit = view.findViewById<Button>(R.id.resrvBtn) as Button

        selectDate.setOnClickListener(View.OnClickListener {
            val now = Calendar.getInstance()
            mDatePickerDialog = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { datePicker, i, i1, i2 ->
                reservDate = Date(i, i1, i2)
                selectDate.setText(i2.toString() + "/" + (i1 + 1) + "/" + i)
            },now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            mDatePickerDialog!!.show()
        })

        selectHour.setOnClickListener(View.OnClickListener {
            val now = Calendar.getInstance()

            mHourDialog = TimePickerDialog(activity, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                reservHour = Time(i2,i,0)
                selectHour.setText(i.toString()+" : "+i2.toString())
            },now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),true)
            mHourDialog!!.show()
        })

        submit.setOnClickListener(View.OnClickListener {
            var reservation = Reservation(nbPr.text.toString().toInt(),selectDate.text.toString(),selectHour.text.toString())
            ReservationItems.list.add(reservation)
            toast("Réservation ajoutée avec succes")
            activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrame,bookingFragment())
                    .commit()
        })
        return view
    }

}// Required empty public constructor
