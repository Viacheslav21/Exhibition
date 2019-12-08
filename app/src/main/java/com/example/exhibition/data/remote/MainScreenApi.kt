package com.example.exhibition.data.remote

import com.example.exhibition.objects.MainObj
import retrofit2.http.GET

interface MainScreenApi {
    @GET("/test.json")
    suspend fun getElements(): List<MainObj>
}