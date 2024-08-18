package com.example.homework.fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework.State
import com.example.homework.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus


class MainViewModel(private val repository: MainRepository) : ViewModel() {

    var searchText = MutableStateFlow("")
    var resultText =
        MutableStateFlow("Здесь будет отображаться результат запроса")
    private val _state = MutableStateFlow<State>(State.Success)
    val state = _state.asStateFlow()

    init {
        searchText.debounce(300).onEach {
            val countStr = it.length
            if (countStr <= 3) {
                _state.value = State.Success
            } else {
                _state.value = State.Loading
                resultText.value =
                    "По запросу \"" + repository.dataSearch(searchText.value) + "\" ничего не найдено"
                _state.value = State.Success
            }

            Log.d("SEARCH STRING", it)
        }.launchIn(viewModelScope + Dispatchers.Default)

    }


}


