package com.kasra.atency.utility

data class CustomResponse<out T>(val status: Status, val data:T?, val message:String?) {
    companion object {
        fun <T> success(data: T?): CustomResponse<T> = CustomResponse(Status.SUCCESS, data, null)
        fun <T> error(message: String?): CustomResponse<T> =
            CustomResponse(Status.ERROR, null, message)
        fun <T> fail(message: String?): CustomResponse<T> = CustomResponse(Status.FAIL, null, message)
        fun <T> loading(): CustomResponse<T> = CustomResponse(Status.LOADING, null, null)
    }


    enum class Status(){
        SUCCESS,
        FAIL,
        ERROR,
        LOADING,
    }
}
