package com.example.komura.api


import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("register")
    suspend fun registerUser(
        @Body registerRequest: RegisterRequest
    ): Response<ResponseBody>
}