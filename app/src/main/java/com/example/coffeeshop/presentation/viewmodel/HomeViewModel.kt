package com.example.coffeeshop.presentation.viewmodel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.data.network.APIs
import com.example.coffeeshop.data.network.RetrofitClient
import com.example.coffeeshop.util.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private lateinit var response: Response<List<Product>>
    private val retrofit= RetrofitClient().getRetrofit()
    val apis: APIs = retrofit!!.create(APIs::class.java)
    private val mutableLiveData: MutableLiveData<NetworkResult<List<Product>>> by lazy {
        MutableLiveData()
    }
    var liveData: LiveData<NetworkResult<List<Product>>> =mutableLiveData
    fun getAllProducts(token:String) {
        var list:List<Product>?=null
        viewModelScope.launch {
            response=apis.getAllProducts("Bearer $token")
            when{
                response.isSuccessful->{ mutableLiveData.postValue(NetworkResult.Success(response.body()!!))
                list=response.body();

                }
                response.code() !=200->{ mutableLiveData.postValue(NetworkResult.Error(response.code().toString()))

                }
            }
        }

    }

}