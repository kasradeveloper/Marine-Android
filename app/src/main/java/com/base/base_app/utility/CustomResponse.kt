package com.base.base_app.utility

data class CustomResponse<out T>(val status: Status, val data:T?, val message:String?) {
    companion object {
        fun <T> success(data: T?): CustomResponse<T> = CustomResponse(Status.SUCCESS, data, null)
        fun <T> error(message: String?): CustomResponse<T> =
            CustomResponse(Status.ERROR, null, message)
        fun <T> fail(message: String?): CustomResponse<T> = CustomResponse(Status.Fail, null, message)
    }


    enum class Status(){
        SUCCESS,
        Fail,
        ERROR,
    }
}