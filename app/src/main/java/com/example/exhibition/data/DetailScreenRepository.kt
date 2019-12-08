package com.example.exhibition.data

import com.example.exhibition.objects.MainObj

interface DetailScreenRepository {
    fun save(list: List<MainObj>)
    fun get(): List<MainObj>?
    fun clear()
}


// For this target more correct to use DB or shared exp(if list will be not so big). But I didn't have time for this
class DetailScreenDataSource : DetailScreenRepository {

    private var variable: List<MainObj>? = null

    override fun save(list: List<MainObj>) {
        variable = list
    }

    override fun get(): List<MainObj>? = variable
    override fun clear() {
        variable = null
    }
}