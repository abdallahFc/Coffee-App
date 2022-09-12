package com.example.coffeeshop.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.model.LoginRequest
import com.example.coffeeshop.data.model.LoginResponse
import com.example.coffeeshop.data.model.RegisterResponse
import com.example.coffeeshop.data.network.APIs
import com.example.coffeeshop.data.network.RetrofitClient
import com.example.coffeeshop.util.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class LoginViewModel:ViewModel() {
    lateinit var response: Response<LoginResponse>
    private var retrofit=RetrofitClient().getRetrofit()
    var api:APIs=retrofit!!.create(APIs::class.java)

    private val mutableLiveData:MutableLiveData<NetworkResult<LoginResponse>>by lazy {
        MutableLiveData()
    }
    var liveData:LiveData<NetworkResult<LoginResponse>> =mutableLiveData

    fun login(loginRequest: LoginRequest){
      viewModelScope.launch {
          response=api.login(loginRequest)
          when{
          response.isSuccessful->mutableLiveData.postValue(NetworkResult.Success(response.body()!!))
          response.code()!=200 ->mutableLiveData.postValue(NetworkResult.Error("Wrong UserName OR Password "))

          }


      }


    }

}