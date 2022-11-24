package com.crexative.composeinstagram.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isButtonEnabled = MutableLiveData<Boolean>()
    val isButtonEnabled : LiveData<Boolean> = _isButtonEnabled


    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password

        _isButtonEnabled.value = enabledLogin(email, password)
    }

    private fun enabledLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6

}