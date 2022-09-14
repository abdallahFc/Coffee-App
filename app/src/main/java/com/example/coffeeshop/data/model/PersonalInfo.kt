package com.example.coffeeshop.data.model

class PersonalInfo {
    var userName: String ?=null
    var mail: String ?=null
    var token:String?=null
    companion object{

        private var instance:PersonalInfo?=null

       fun getInstance():PersonalInfo{
           if (instance==null)
               instance= PersonalInfo()
           return instance as PersonalInfo
       }


    }
}