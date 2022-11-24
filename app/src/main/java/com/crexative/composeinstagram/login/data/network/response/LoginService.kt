package com.crexative.composeinstagram.login.data.network.response

import com.crexative.composeinstagram.core.network.RetrofitHelper
import com.crexative.composeinstagram.login.data.network.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String) : Boolean {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin(user, password)
            response.body()?.success ?: false
        }
    }
}