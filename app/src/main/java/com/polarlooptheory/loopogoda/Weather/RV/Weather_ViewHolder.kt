package com.polarlooptheory.loopogoda.Weather.RV

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.polarlooptheory.loopogoda.R


class Weather_ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val time: TextView
    val date: TextView
    val icon: ImageView
    val temp: TextView
    init{
        time = itemView.findViewById(R.id.tab_time)
        date = itemView.findViewById(R.id.tab_date)
        icon = itemView.findViewById(R.id.tab_image)
        temp = itemView.findViewById(R.id.tab_temp)
    }
}