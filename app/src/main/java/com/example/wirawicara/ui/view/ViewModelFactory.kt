package com.example.wirawicara.ui.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wirawicara.data.di.Injection
import com.example.wirawicara.ui.main.MainViewModel
import com.example.wirawicara.ui.repository.UserRepo

class ViewModelFactory private constructor(private val userRepository: UserRepo): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(userRepository) as T
        }
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(userRepository) as T
        }

        throw IllegalArgumentException("Unknown Viewmodel CLass: " + modelClass.name)
    }

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

       fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
//                    Injection.provideRepository(context),
                    Injection.provideUserRepository(context),
                )
            }.also { instance = it }
    }

}