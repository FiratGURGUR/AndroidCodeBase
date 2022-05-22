package firat.gurgur.codebase.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): DataResource<T> {
        return withContext(Dispatchers.IO) {
            try {
                DataResource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        DataResource.Failure(false, throwable.code(), throwable.response()?.errorBody(), throwable.message)
                    }
                    else -> {
                        if (throwable.message == "NO_INTERNET") {
                            DataResource.Failure(true, null, null, throwable.message)
                        } else DataResource.Failure(true, 999, null, throwable.message) // CHANGE THIS TO FALSE
                    }
                }
            }
        }
    }
}