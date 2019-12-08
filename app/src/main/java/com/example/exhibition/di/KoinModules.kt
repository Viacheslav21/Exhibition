package com.example.exhibition.di

import com.example.exhibition.R
import com.example.exhibition.data.DefaultMainScreenRepository
import com.example.exhibition.data.DetailScreenDataSource
import com.example.exhibition.data.DetailScreenRepository
import com.example.exhibition.data.MainScreenRepository
import com.example.exhibition.data.remote.MainScreenApi
import com.example.exhibition.main.MainViewModel
import com.example.exhibition.network.RetrofitManager
import com.example.exhibition.ui.detail_screen.DetailScreenViewModel
import com.example.exhibition.ui.main_screen.MainScreenViewModel
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val systemModule = module {
    single { GsonBuilder().create() }
    single { RetrofitManager(androidContext().getString(R.string.base_url), get()) }
}

val mainModule = module {
    viewModel { MainViewModel() }
}


val mainScreenModule = module {
    single { get<RetrofitManager>().getService(MainScreenApi::class.java) }
    single<MainScreenRepository> { DefaultMainScreenRepository(get()) }

    viewModel { MainScreenViewModel(get(), get()) }

}

val detailScreenModule = module {
    single<DetailScreenRepository> { DetailScreenDataSource() }
    viewModel { DetailScreenViewModel(get()) }

}

