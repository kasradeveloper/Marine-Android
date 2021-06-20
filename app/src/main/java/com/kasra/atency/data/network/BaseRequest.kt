package com.kasra.atency.data.network

import com.kasra.atency.utility.CustomResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.json.JSONObject
import retrofit2.Response


suspend fun <T> getResult(call: suspend () -> Response<T>): Flow<CustomResponse<T>> {
    try {
        val response = call()
        if (response.isSuccessful || response.code() == 201) {
            val body = response.body()
            return if (body != null) flowOf(CustomResponse.success(body))
            else return flowOf(CustomResponse.error(response.message()))
        }
//        return flowOf(CustomResponse.error(response.raw().message))
        val json = JSONObject(response.errorBody()?.string()!!)
        return if (json.has("error_description"))
            flowOf(CustomResponse.error(json.get("error_description") as String))
        else
            flowOf(CustomResponse.error(json.get("Message") as String))
    } catch (e: Exception) {
        return flowOf(CustomResponse.fail(e.message ?: e.toString()))
    }
}


