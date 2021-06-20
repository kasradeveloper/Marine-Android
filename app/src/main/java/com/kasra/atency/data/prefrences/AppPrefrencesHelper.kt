package com.kasra.atency.data.prefrences

interface AppPrefrencesHelper {
    fun setAceesToken(token:String): Unit?
    fun getAccessToken():String?
    fun getIsLogin(): Boolean?
    fun setIsLogin(isLogin: Boolean):Unit?
    fun clearAllThing()
    fun setRefreshToken(token: String): Unit?
    fun getRefreshToken(): String?
    fun setInquiryId(inquiryId: String): Unit?
    fun getInquiryId(): String?
}