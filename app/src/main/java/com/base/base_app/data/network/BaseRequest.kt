package com.base.base_app.data.network

import com.base.base_app.utility.CustomResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response


suspend fun <T> getResult(call: suspend () -> Response<T>): Flow<CustomResponse<T>> {
    try {
        val response = call()
        if (response.isSuccessful || response.code() == 201) {
            val body = response.body()
            return if (body != null) flowOf(CustomResponse.success(body))
            else return flowOf(CustomResponse.error(response.message()))
        }
        return flowOf(CustomResponse.error(response.message()))
    } catch (e: Exception) {
        return flowOf(CustomResponse.fail(e.message ?: e.toString()))
    }
}


