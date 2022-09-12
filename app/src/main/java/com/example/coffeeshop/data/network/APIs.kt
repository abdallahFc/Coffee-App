package com.example.coffeeshop.data.network

import com.example.coffeeshop.data.model.RegisterRequest
import com.example.coffeeshop.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIs {
 @POST("api/v1/user/signup")
suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

}