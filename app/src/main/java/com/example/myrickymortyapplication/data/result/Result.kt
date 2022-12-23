package com.example.myrickymortyapplication.data.result

sealed class Result<T>(val data :T? = null , val message:String? =null){

     class Success<T>(data :T?=null) :Result<T>(data)
     class Error<T>(message:String,data :T?) :Result<T>(data,message)
     class Loading<T>(data :T? = null) :Result<T>(data)
}
