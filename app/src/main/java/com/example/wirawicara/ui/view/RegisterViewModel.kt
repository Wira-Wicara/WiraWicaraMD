package com.example.wirawicara.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.wirawicara.ui.repository.UserRepo

class RegisterViewModel(private val userRepo: UserRepo): ViewModel() {
    fun addNewUser(username: String, email: String, password: String) = userRepo.addNewUser(username, email, password).asLiveData()
}