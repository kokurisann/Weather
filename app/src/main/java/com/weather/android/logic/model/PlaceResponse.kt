package com.weather.android.logic.model

import com.google.gson.annotations.SerializedName

//定义相对应的类和属性

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)