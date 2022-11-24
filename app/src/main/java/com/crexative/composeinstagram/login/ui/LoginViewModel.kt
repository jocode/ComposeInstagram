package com.crexative.composeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crexative.composeinstagram.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isButtonEnabled = MutableLiveData<Boolean>()
    val isButtonEnabled : LiveData<Boolean> = _isButtonEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading


    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password

        _isButtonEnabled.value = enabledLogin(email, password)
    }

    private fun enabledLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6

    fun handleOnLogin() {
        _isLoading.value = true
        viewModelScope.launch {
            val result = loginUseCase(email.value.orEmpty(), password.value.orEmpty())

            if (result) {
                // Navegar a la siguiente pantall
                Log.e("ViewModel", "result success")
                _isLoading.value = false
            }
        }
    }

}