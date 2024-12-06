package com.example.komura.api

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)

data class RegisterResponse(
    val message: String
)

sealed class RegisterState {
    data class Success(val message: String) : RegisterState()
    data class Error(val errorMessage: String) : RegisterState()
}