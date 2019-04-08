package com.polarlooptheory.loopogoda.City

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.polarlooptheory.loopogoda.Forecast
import com.polarlooptheory.loopogoda.NavigationHost
import com.polarlooptheory.loopogoda.R
import com.polarlooptheory.loopogoda.Weather.WeatherFragment
import kotlinx.android.synthetic.main.fragment_city.view.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CityFragment: Fragment() {
    private val client = OkHttpClient()
    private var json : JSONObject = JSONObject()
    private var name = String()
    private var ene = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city, container, false)
        view.applyCity.setOnClickListener {
            name = view.date.text.toString().trim().capitalize()
            if(name != "" && ene){
                ene = false
                run(resources.getString(R.string.api_addres)+name)
            }
        }
        return view
    }
    private fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) { ene=true }
            override fun onResponse(call: Call, response: Response) {
                json = JSONObject(response.body()?.string())
                if(json.getString("cod")=="200"){
                    val count = json.getInt("cnt") - 1
                    val forecasts = Array(count+1){Forecast(0.0,0.0,0.0,0,0.0,0,0.0,0,"","")}
                    val arr = json.getJSONArray("list")
                    for (i in 0..count){
                        val el = JSONObject(arr[i].toString())
                        val date = el.getLong("dt")
                        val main = el.getJSONObject("main")
                        val tmp = main.getDouble("temp")
                        val tmp_min = main.getDouble("temp_min")
                        val tmp_max = main.getDouble("temp_max")
                        val pressure = main.getDouble("pressure")
                        val humidity = main.getInt("humidity")
                        val clouds = el.getJSONObject("clouds").getInt("all")
                        val wind = el.getJSONObject("wind").getDouble("speed")
                        val weather = el.getJSONArray("weather").getJSONObject(0)
                        val icon = weather.getString("icon")
                        val desc = weather.getString("description")
                        val obj = Forecast(tmp,tmp_min,tmp_max,humidity,pressure,clouds,wind,date,desc,icon)
                        forecasts[i] = obj
                }
                    val arg = Bundle()
                    arg.putParcelableArray("forecasts",forecasts)
                    arg.putString("name",name)
                    val frag = WeatherFragment()
                    frag.arguments = arg
                    (activity as NavigationHost).navigateTo(frag,true)
                }
                else{
                }
                ene = true
            }
        })
    }
}