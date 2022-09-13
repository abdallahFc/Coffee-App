package com.example.coffeeshop.data.network

import com.example.coffeeshop.data.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface APIs {
 @POST("api/v1/user/signup")
suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
@POST("api/v1/user/login")
suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
@GET("api/v1/product/")
suspend fun getAllProducts(@Header("Authorization") token:String):Response<List<Product>>

}