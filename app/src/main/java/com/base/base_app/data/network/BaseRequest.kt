package com.base.base_app.data.network

import com.base.base_app.utility.CustomResponse
import retrofit2.Response


abstract class BaseRequest {
    protected suspend fun <T> getResult(call:suspend() -> Response<T>): CustomResponse<T> {
        try {
            val response = call()
            if (response.isSuccessful||response.code()==201) {
                val body = response.body()

                return if (body != null) CustomResponse.success(body)
                else return CustomResponse.error(response.message())
            }
            return  CustomResponse.error(response.message())
        } catch (e: Exception) {
            return CustomResponse.fail(e.message ?: e.toString())
        }
    }


}