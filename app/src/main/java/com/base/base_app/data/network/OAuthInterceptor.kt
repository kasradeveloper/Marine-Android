package com.base.base_app.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OAuthInterceptor @Inject constructor() : Interceptor {
    companion object {
        var accessToekn: String = ""
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().addHeader("Authorization","Bearer ".plus(accessToekn)).build()
        return chain.proceed(request)
    }
}