package com.polarlooptheory.loopogoda.Weather

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.polarlooptheory.loopogoda.Forecast
import com.polarlooptheory.loopogoda.R
import com.polarlooptheory.loopogoda.Weather.RV.RVAdapter
import com.polarlooptheory.loopogoda.Weather.VP.VPAdapter
import kotlinx.android.synthetic.main.fragment_weather.view.*

class WeatherFragment: Fragment() {
        private var name = "Gliwice"
        private var forecasts : Array<Forecast> = arrayOf()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_weather, container, false)
            view.rvTabs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            view.rvTabs.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager.HORIZONTAL))
            view.pager.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val sndSnapHelper = LinearSnapHelper()
            sndSnapHelper.attachToRecyclerView(view.pager)
            forecasts = (arguments!!.getParcelableArray("forecasts") as Array<Forecast>)
            name = arguments!!.getString("name")
            view.pager.adapter = VPAdapter(forecasts)
            view.rvTabs.adapter = RVAdapter(forecasts){
                    x -> view.pager.smoothScrollToPosition(x)
            }
            view.backButton.setOnClickListener {
                fragmentManager!!.popBackStack()
            }
            view.name.text = name
            return view
        }
    companion object {
        fun getDrawId(name: String):Int = when(name){
            "01d"-> R.drawable.i01d
            "01n"-> R.drawable.i01n
            "02d"-> R.drawable.i02d
            "02n"-> R.drawable.i02n
            "03d"-> R.drawable.i03d
            "03n"-> R.drawable.i03n
            "04d"-> R.drawable.i04d
            "04n"-> R.drawable.i04n
            "09d"-> R.drawable.i09d
            "09n"-> R.drawable.i09n
            "10d"-> R.drawable.i10d
            "10n"-> R.drawable.i10n
            "11d"-> R.drawable.i11d
            "11n"-> R.drawable.i11n
            "13d"-> R.drawable.i13d
            "13n"-> R.drawable.i13n
            "50d"-> R.drawable.i50d
            "50n"-> R.drawable.i50n
            else -> 0
        }
    }
}

