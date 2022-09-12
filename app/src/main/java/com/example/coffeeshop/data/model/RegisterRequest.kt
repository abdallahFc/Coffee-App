package com.example.coffeeshop.data.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    val userName:String,
    val email:String,
    val password:String )