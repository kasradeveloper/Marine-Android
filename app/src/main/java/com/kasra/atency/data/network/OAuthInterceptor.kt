package com.kasra.atency.data.network

import com.kasra.atency.data.prefrences.AppPrefrencesHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OAuthInterceptor @Inject constructor(private val prefrencesHelper: AppPrefrencesHelper) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        lateinit var newUrl:HttpUrl
        if (prefrencesHelper.getWebSite().isNullOrEmpty())
            newUrl = request.url
        else
            newUrl = request.url.newBuilder().host(prefrencesHelper.getWebSite()!!+"."+request.url.host).build()
        runBlocking(Dispatchers.IO) {
            request =
                request.newBuilder()
                    .addHeader("Authorization", "Bearer ".plus(prefrencesHelper.getAccessToken()))
                    .url(newUrl).build()
        }
        return chain.proceed(request)
    }
}
