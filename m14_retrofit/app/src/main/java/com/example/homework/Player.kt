package com.example.homework

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Player(
    @Json(name = "luckyNumber")
    val luckyNumber: Int,
    @Json(name = "username")
    val username: String
)