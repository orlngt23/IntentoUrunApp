package com.example.urunapp.ui.login.ui

import java.lang.Exception

sealed class LoginUiStatus {
    object Resume : LoginUiStatus()
    class Error(val exception: Exception) : LoginUiStatus()
    data class ErrorWithMessage(val message: String) : LoginUiStatus()
    object Success : LoginUiStatus()
}