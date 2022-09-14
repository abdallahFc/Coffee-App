package com.example.coffeeshop.presentation.viewmodel

import com.example.coffeeshop.data.model.CartItem
import java.util.ArrayList

class AddToCart {

    companion object{
     var list:ArrayList<CartItem>?=null
     //private var instance:AddToCart?=null
    fun getInstance():ArrayList<CartItem>{
       if(list ==null){
           list =ArrayList()
       }


        return list as ArrayList<CartItem>
        }
    }

}