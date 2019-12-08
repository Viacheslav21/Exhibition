package com.example.exhibition.data

import com.example.exhibition.data.remote.MainScreenApi
import com.example.exhibition.objects.MainObj


interface MainScreenRepository {
    suspend fun getElements(): List<MainObj>
}

class DefaultMainScreenRepository(
    private val remoteAuthDataSource: MainScreenApi
) : MainScreenRepository {
    override suspend fun getElements(): List<MainObj> =
        remoteAuthDataSource.getElements()
}