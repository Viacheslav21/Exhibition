package com.example.exhibition.ui.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.exhibition.data.DetailScreenRepository
import com.example.exhibition.data.MainScreenRepository
import com.example.exhibition.main.BaseViewModel
import com.example.exhibition.objects.MainObj
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val mainScreenRepository: MainScreenRepository,
    private val detailRepository: DetailScreenRepository
) : BaseViewModel() {


    private val _showMainScreenEvent = MutableLiveData<List<MainObj>>()
    val showMainScreenEvent: LiveData<List<MainObj>> = _showMainScreenEvent


    fun getElements() {
        viewModelScope.launch {
            showLoading(true)
            try {
                if (_showMainScreenEvent.value.isNullOrEmpty()) {
                    val list = mainScreenRepository.getElements()
                    detailRepository.save(list)
                    _showMainScreenEvent.postValue(list)
                } else
                    _showMainScreenEvent.postValue(_showMainScreenEvent.value)

            } catch (e: Exception) {
                handleError(e)
            } finally {
                showLoading(false)
            }
        }
    }
}