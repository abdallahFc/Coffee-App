package com.example.coffeeshop.data.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("userName") val userName:String,
    @SerializedName("password") val password:String,
    @SerializedName("email") val email:String)



