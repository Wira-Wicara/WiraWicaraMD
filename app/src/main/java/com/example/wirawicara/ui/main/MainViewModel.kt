package com.example.wirawicara.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.wirawicara.ui.repository.UserRepo
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val userRepository: UserRepo): ViewModel() {

    fun getUserToken() = userRepository.getUserToken().asLiveData(Dispatchers.IO)
}