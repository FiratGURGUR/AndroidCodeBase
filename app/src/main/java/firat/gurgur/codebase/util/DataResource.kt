package firat.gurgur.codebase.util

import okhttp3.ResponseBody

sealed class DataResource<out T> {
    data class Success<out T>(val value: T): DataResource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?,
        val otherMessage: String?
    ): DataResource<Nothing>()

    object Loading: DataResource<Nothing>()

    fun onSuccess(successHandler: (T) -> Unit): DataResource<T> = this.also {
        if (this is DataResource.Success) successHandler(value)
    }

    fun onError(errorHandler: (Failure) -> Unit): DataResource<T> = this.also {
        if (this is Failure) errorHandler(this)
    }



}
