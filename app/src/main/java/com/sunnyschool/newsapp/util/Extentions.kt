package com.sunnyschool.newsapp.util

import com.sunnyschool.newsapp.entity.local.CallException
import com.sunnyschool.newsapp.entity.local.CallResult
import retrofit2.Response
import java.lang.Exception

suspend fun <R> makeApiCall(
        call: suspend () -> CallResult<R>
) = try {
    call()
} catch (e: Exception) {
    CallResult.Error(CallException<Nothing>())
}

fun <R> analyzeResponse(
        response: Response<R>
): CallResult<R> {
    return if(response.isSuccessful){
        CallResult.Success(response.body())
    }else{
        CallResult.Error(CallException<Nothing>(response.code(), response.message()))
    }
}
