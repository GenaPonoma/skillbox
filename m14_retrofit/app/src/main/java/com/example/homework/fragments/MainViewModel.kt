package com.example.homework.fragments

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.homework.models.Result
import com.example.homework.models.User
import com.example.homework.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())


    private val _result = MutableStateFlow(emptyList<Result>())
    val result = _result.asStateFlow()

    fun fetchData(fragment: Context, view: ImageView) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsers().let {
                _users.value = listOf(it)
            }
            if (_users.value.isNotEmpty()) {
                _users.value.map { it.results }
                    .also { it -> _result.value = it.first { it.isNotEmpty() } }
            }
            launch(Dispatchers.Main) {
                if (result.value.isNotEmpty()) {
                    val thumbnailUrl = result.value.firstOrNull()?.picture?.large
                    if (thumbnailUrl != null) {
                        Glide.with(fragment).load(thumbnailUrl)
                            .into(view)
                    }
                }
            }

        }
    }
}

