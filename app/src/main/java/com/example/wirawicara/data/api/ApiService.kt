package com.example.wirawicara.data.api

import com.example.wirawicara.data.request.LoginRequest
import com.example.wirawicara.data.request.RegistrationRequest
import com.example.wirawicara.data.request.ResponseDetail
import com.example.wirawicara.data.request.ResponseLogin
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface APIService {
    @POST("register")
    fun registUser(@Body requestRegister: RegistrationRequest): Call<ResponseDetail>

    @POST("login")
    fun loginUser(@Body requestLogin: LoginRequest): Call<ResponseLogin>

}