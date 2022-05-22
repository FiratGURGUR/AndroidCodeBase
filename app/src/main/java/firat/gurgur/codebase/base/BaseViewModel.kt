package firat.gurgur.codebase.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import firat.gurgur.codebase.util.DataResource


abstract class BaseViewModel : ViewModel() {

    val progressStatus = MutableLiveData<Boolean>()
    val status = MutableLiveData<DataResource<Nothing>>()

    suspend fun <T : Any> call(apiCall: suspend () -> DataResource<T>): DataResource<T> {
        val result = apiCall()

        when (result) {
            is DataResource.Failure -> {
                status.value = result
            }

            else -> Unit
        }

        return result
    }


}