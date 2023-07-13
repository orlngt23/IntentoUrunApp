package com.example.urunapp.repository

import com.example.urunapp.network.ApiResponse
import com.example.urunapp.network.dto.login.LoginRequest
import com.example.urunapp.network.dto.register.RegisterRequest
import com.example.urunapp.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {

    suspend fun login(email: String, password: String): ApiResponse<String> {

        try {
            val response = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.token)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun register(name: String, email: String, password: String): ApiResponse<String> {

        try {
            val response = api.register(RegisterRequest(name, email, password))
            return ApiResponse.Success(response.message)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid name, email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }


}