package com.crexative.composeinstagram.login.data

import com.crexative.composeinstagram.login.data.network.response.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user: String, password: String) : Boolean = api.doLogin(user, password)
}