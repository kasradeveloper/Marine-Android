package com.kasra.atency.data.network

import com.kasra.atency.data.prefrences.AppPrefrencesHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OAuthInterceptor @Inject constructor(val prefrencesHelper: AppPrefrencesHelper) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        runBlocking(Dispatchers.IO) {
            request =
                request.newBuilder().addHeader("Authorization", "Bearer ".plus(prefrencesHelper.getAccessToken())).build()
        }
        return chain.proceed(request)
    }
}
