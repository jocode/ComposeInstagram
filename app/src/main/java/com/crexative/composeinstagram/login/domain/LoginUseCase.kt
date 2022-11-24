package com.crexative.composeinstagram.login.domain

import com.crexative.composeinstagram.login.data.LoginRepository

class LoginUseCase {

    val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String) : Boolean {
        return repository.doLogin(user, password)
    }

}