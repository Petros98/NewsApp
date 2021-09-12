package com.sunnyschool.newsapp.entity.local

sealed class CallResult<out S> {
    data class Success<S>(val data: S?) : CallResult<S>()
    data class Error<E>(val errors: CallException<E>) : CallResult<E>()
}