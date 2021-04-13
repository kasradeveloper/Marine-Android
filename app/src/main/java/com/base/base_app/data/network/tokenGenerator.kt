package com.base.base_app.data.network

import com.base.base_app.data.network.ApiServices
import com.base.base_app.data.prefrences.AppPrefrencesHelper
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class tokenGenerator @Inject constructor(prefrencesHelper: AppPrefrencesHelper, private val services: ApiServices){
//    : okhttp3.Authenticator {
//    override fun authenticate(route: Route?, response: Response): Request? {
//        if(response.code()==401){
//
//        }
//    }
}