package com.sunnyschool.newsapp.entity.local

data class CallException<ErrorBody>(val errorCode: Int = 1234, val errorMessage:String?=null)