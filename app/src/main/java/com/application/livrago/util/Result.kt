package com.application.livrago.util

sealed class Result<T>(val data : T? = null, val e : Throwable? = null){
    object Loading : Result<Nothing>()
    class Success<T>(data: T?) : Result<T>(data)
    class Error<T>(e: Throwable) : Result<T>(e= e)
}