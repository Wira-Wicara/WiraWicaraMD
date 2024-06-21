package com.example.wirawicara.data.request

data class RegistrationRequest (
    val email: String,
    val password: String
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class StoryKids(
    val username: String,
    val kidName: String,
    val kidAge: Int,
    val kidDescription: String
)
data class ResponseLogin(
    var error: Boolean,
    var message: String
)
data class ResponseDetail(
    var error: Boolean,
    var message: String
)
