package com.polarlooptheory.loopogoda.Weather.RV

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.polarlooptheory.loopogoda.Forecast
import com.polarlooptheory.loopogoda.R
import com.polarlooptheory.loopogoda.Weather.WeatherFragment

class RVAdapter(private val list: Array<Forecast>,private val listener : (Int)->Unit): RecyclerView.Adapter<Weather_ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Weather_ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.weather_tab, parent, false)
        return Weather_ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Weather_ViewHolder, position: Int) {
        holder.date.text = list[position].read(Forecast.ITEM.DAY)
        holder.temp.text = list[position].read(Forecast.ITEM.TMP)
        holder.time.text = list[position].read(Forecast.ITEM.HOUR)
        val id = WeatherFragment.getDrawId(list[position].read(Forecast.ITEM.ICON))
        holder.icon.setImageResource(id)
        holder.itemView.setOnClickListener {
            listener(position)
        }
    }
}

