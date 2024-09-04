package com.example.homework.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "info")
    val info: Info?,
    @Json(name = "results")
    val results: List<Result>
)