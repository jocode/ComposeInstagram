package com.crexative.composeinstagram.login.data

import com.crexative.composeinstagram.login.data.network.response.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api : LoginService
){

    suspend fun doLogin(user: String, password: String) : Boolean = api.doLogin(user, password)

}