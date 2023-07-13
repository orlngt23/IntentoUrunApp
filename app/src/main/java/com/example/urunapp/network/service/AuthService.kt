package com.example.urunapp.network.service

import com.example.urunapp.network.dto.login.LoginRequest
import com.example.urunapp.network.dto.login.LoginResponse
import com.example.urunapp.network.dto.register.RegisterRequest
import com.example.urunapp.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

   @POST("api/auth/signin")
   suspend fun login(@Body credentials: LoginRequest): LoginResponse

   @POST("api/auth/signup")
   suspend fun register(@Body credentials: RegisterRequest): RegisterResponse

}