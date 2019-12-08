package com.example.exhibition.main

interface BaseView<T: BaseViewModel> {
    val viewModel: T

    fun subscribeToEvents()

    fun handleError(throwable: Throwable)

    fun showLoading(isLoading: Boolean)
}