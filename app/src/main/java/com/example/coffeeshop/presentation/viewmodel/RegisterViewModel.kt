package com.example.coffeeshop.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.model.RegisterRequest
import com.example.coffeeshop.data.model.RegisterResponse
import com.example.coffeeshop.data.network.APIs
import com.example.coffeeshop.data.network.RetrofitClient
import com.example.coffeeshop.util.NetworkResult
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class RegisterViewModel:ViewModel() {
    private lateinit var response:Response<RegisterResponse>
   private var retrofit= RetrofitClient().getRetrofit()
    private var apIs: APIs = retrofit!!.create(APIs::class.java)

   private val mutableLiveData : MutableLiveData<NetworkResult<RegisterResponse>> by lazy {
        MutableLiveData()
    }
    var liveData:LiveData<NetworkResult<RegisterResponse>> =mutableLiveData
    fun register(registerRequest: RegisterRequest){
       viewModelScope.launch{
         response=apIs.register(registerRequest)
             when{
                //response.isSuccessful->Toast.makeText(context,"",Toast.LENGTH_LONG)
                response.isSuccessful-> mutableLiveData.postValue(NetworkResult.Success(response.body()!!))
                response.code() ==500-> mutableLiveData.postValue(NetworkResult.Error("mail is already taken"))

            }

        }


    }

}
