package firat.gurgur.codebase.repository

import firat.gurgur.codebase.data.ApiService
import firat.gurgur.codebase.util.BaseRepository
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getCharacters()  = safeApiCall { apiService.getAllCharacters() }

}