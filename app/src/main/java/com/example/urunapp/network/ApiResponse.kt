package com.example.urunapp.network
import androidx.lifecycle.LiveData
import java.lang.Exception

sealed class ApiResponse<T> {

    data class Success<T>(val data: T) : ApiResponse<T>()

    data class Error<T>(val exception: Exception) : ApiResponse<T>()

    data class ErrorWithMessage<T>(val message: String) : ApiResponse<T>()

}