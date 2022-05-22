package firat.gurgur.codebase.ui.tab1


import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import firat.gurgur.codebase.base.BaseViewModel
import firat.gurgur.codebase.model.ResponseModel
import firat.gurgur.codebase.repository.ApiRepository
import firat.gurgur.codebase.util.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ApiViewModel @Inject constructor(private val repository: ApiRepository) : BaseViewModel() {

    val clickActions = SingleLiveEvent<HomeClickActions>()
    val _characterList = SingleLiveEvent<ResponseModel>()
    val characterList: LiveData<ResponseModel> = _characterList

    fun getCharacterApiCall(){
        progressStatus.value = true
        viewModelScope.launch {
            call { repository.getCharacters() }
                .onSuccess { response ->
                    _characterList.value = response
                    progressStatus.value = false
                }.onError {
                    progressStatus.value = false
                }
        }
    }



    fun onCharacterItemClicked(){
        clickActions.value = HomeClickActions.CharacterClicked
    }



}