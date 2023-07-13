package com.example.urunapp.network.dto.register

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
)