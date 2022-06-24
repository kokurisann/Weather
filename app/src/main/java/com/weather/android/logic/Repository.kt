package com.weather.android.logic

import androidx.lifecycle.liveData
import com.weather.android.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers

//仓库层的统一封装入口
//因为本案例中只是进行搜索城市的天气数据，故没有太多缓存的必要，所以只有网络请求去获取最新的数据

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = WeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "OK") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        emit(result)
    }

}