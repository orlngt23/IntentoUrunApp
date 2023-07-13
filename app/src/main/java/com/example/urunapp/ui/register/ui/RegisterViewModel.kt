package com.example.urunapp.ui.register.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.urunapp.RetrofitApplication
import com.example.urunapp.network.ApiResponse
import com.example.urunapp.repository.CredentialsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel(private val repository: CredentialsRepository) : ViewModel() {
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var password = MutableLiveData("")

    private val _status = MutableLiveData<RegisterUiStatus>(RegisterUiStatus.Resume)
    val status: LiveData<RegisterUiStatus>
        get() = _status

    private fun register() {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.register(name.value!!, email.value!!, password.value!!)) {
                    is ApiResponse.Error -> RegisterUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> RegisterUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> RegisterUiStatus.Success
                }
            )
        }
    }


    fun onRegister() {
        if (!validateData()) {
            _status.value = RegisterUiStatus.ErrorWithMessage("Wrong Information")
            return
        }
        viewModelScope.launch {
            try {
                val response = repository.register(name.value!!, email.value!!, password.value!!)
                if (response is ApiResponse.Success) {
                    // Registro exitoso
                    _status.value = RegisterUiStatus.Success
                } else if (response is ApiResponse.ErrorWithMessage) {
                    // Error en el registro (nombre de usuario o email ya existen)
                    _status.value = RegisterUiStatus.ErrorWithMessage(response.message)
                } else {
                    // Error en la solicitud (error de red, error del servidor, etc.)
                    _status.value = RegisterUiStatus.Error(Throwable("Request error") as Exception)
                }
            } catch (e: Throwable) {
                // Error en la solicitud (error de red, error del servidor, etc.)
                _status.value = RegisterUiStatus.Error(e as Exception)
            }
        }
    }




    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            email.value.isNullOrEmpty() -> return false
            password.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearStatus() {
        _status.value = RegisterUiStatus.Resume
    }

    fun clearData() {
        name.value = ""
        email.value = ""
        password.value = ""
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RetrofitApplication
                RegisterViewModel(app.credentialsRepository)
            }
        }
    }
}