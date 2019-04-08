package com.polarlooptheory.loopogoda.Weather.VP

import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polarlooptheory.loopogoda.Forecast
import com.polarlooptheory.loopogoda.R
import com.polarlooptheory.loopogoda.Weather.WeatherFragment

class VPAdapter(private val list: Array<Forecast>) : RecyclerView.Adapter<VPFragment>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VPFragment {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.weather_card, parent, false)
        return VPFragment(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VPFragment, position: Int) {
        holder.date.text = "${list[position].read(Forecast.ITEM.DAY)}, ${list[position].read(Forecast.ITEM.HOUR)}"
        holder.temp.text = list[position].read(Forecast.ITEM.TMP)
        holder.temp_max.text = list[position].read(Forecast.ITEM.TMP_MAX)
        holder.temp_min.text = list[position].read(Forecast.ITEM.TMP_MIN)
        holder.humidity.text = list[position].read(Forecast.ITEM.HUMIDITY)
        holder.pressure.text = list[position].read(Forecast.ITEM.PRESSURE)
        holder.wind.text = list[position].read(Forecast.ITEM.WIND)
        holder.desc.text = list[position].read(Forecast.ITEM.DESC)
        val id = WeatherFragment.getDrawId(list[position].read(Forecast.ITEM.ICON))
        holder.icon.setImageResource(id)
    }
}