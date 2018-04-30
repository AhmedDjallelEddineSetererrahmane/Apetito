package com.esi.tdm.apetito.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.models.Reservation

/**
 * Created by djall on 4/30/2018.
 */
class ReservationAdapter(_ctx: Context, _reservationList:List<Reservation>):BaseAdapter() {
    var ctx = _ctx
    var reservationList = _reservationList


    override fun getItem(p0: Int) = reservationList.get(p0)

    override fun getItemId(p0: Int) = reservationList.get(p0).hashCode().toLong()

    override fun getCount(): Int = reservationList.size

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder: ReservationAdapter.ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.reserv_layout,p2,false)
            var nbPr = view?.findViewById<TextView>(R.id.nbPR) as TextView
            var date = view?.findViewById<TextView>(R.id.date) as TextView
            var hour = view?.findViewById<TextView>(R.id.hour) as TextView
            var index = view?.findViewById<TextView>(R.id.index) as TextView
            viewHolder = ReservationAdapter.ViewHolder(index,nbPr,date,hour)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as ReservationAdapter.ViewHolder
        }

        viewHolder.nbPR.setText("Nombre de Personne : "+reservationList.get(p0).peopleNB)
        viewHolder.date.setText("Date de réservation : "+reservationList.get(p0).date)
        viewHolder.Hour.setText("Heure de résarvation : "+reservationList.get(p0).hour)
        viewHolder.index.setText((p0+1).toString())
        return view
    }

    private data class ViewHolder(var index:TextView,var nbPR: TextView, var date: TextView, var Hour: TextView)
}
