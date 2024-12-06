package com.example.komura.api

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ApiViewModel : ViewModel() {

    private val _registerState = mutableStateOf<RegisterState?>(null)
    val registerState: RegisterState? get() = _registerState.value

    fun registerUser(username: String, email: String, password: String) {
        val registerRequest = RegisterRequest(
            username = username,
            email = email,
            password = password
        )

        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.registerUser(registerRequest)
                if (response.isSuccessful) {
                    val responseMessage = response.body()?.string() ?: "Registration Successful"
                    _registerState.value = RegisterState.Success(responseMessage)
                } else {
                    _registerState.value = RegisterState.Error(response.errorBody()?.string() ?: "Unknown Error")
                }
            } catch (e: IOException) {
                _registerState.value = RegisterState.Error("Network Error: ${e.message}")
            } catch (e: HttpException) {
                _registerState.value = RegisterState.Error("HTTP Error: ${e.message()}")
            } catch (e: Exception) {
                _registerState.value = RegisterState.Error("Unexpected Error: ${e.message}")
            }
        }
    }
}
