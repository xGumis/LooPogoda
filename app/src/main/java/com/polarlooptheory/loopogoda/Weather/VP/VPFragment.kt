package com.polarlooptheory.loopogoda.Weather.VP

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.polarlooptheory.loopogoda.R

class VPFragment(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val temp : TextView
    val temp_max : TextView
    val temp_min : TextView
    val humidity : TextView
    val pressure : TextView
    val wind : TextView
    val date : TextView
    val desc : TextView
    val icon : ImageView
    init {
        temp = itemView.findViewById(R.id.temp)
        temp_max = itemView.findViewById(R.id.temp_max)
        temp_min = itemView.findViewById(R.id.temp_min)
        humidity = itemView.findViewById(R.id.humidity)
        pressure = itemView.findViewById(R.id.pressure)
        wind = itemView.findViewById(R.id.wind)
        date = itemView.findViewById(R.id.date)
        desc = itemView.findViewById(R.id.desc)
        icon = itemView.findViewById(R.id.icon)
    }
}