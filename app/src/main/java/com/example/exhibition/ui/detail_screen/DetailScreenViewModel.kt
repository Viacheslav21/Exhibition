package com.example.exhibition.ui.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.exhibition.data.DetailScreenRepository
import com.example.exhibition.main.BaseViewModel
import com.example.exhibition.objects.MainObj
import kotlinx.coroutines.launch

class DetailScreenViewModel(
    private val detailScreenRepository: DetailScreenRepository
) : BaseViewModel() {

    private val _showDetailScreenEvent = MutableLiveData<List<MainObj>>()
    val showMainScreenEvent: LiveData<List<MainObj>> = _showDetailScreenEvent


    fun getElements() {
        viewModelScope.launch {
            showLoading(true)
            try {
                if (_showDetailScreenEvent.value.isNullOrEmpty())
                    _showDetailScreenEvent.postValue(detailScreenRepository.get())
                else
                    _showDetailScreenEvent.postValue(_showDetailScreenEvent.value)

            } catch (e: Exception) {
                handleError(e)
            } finally {
                showLoading(false)
            }
        }
    }
}