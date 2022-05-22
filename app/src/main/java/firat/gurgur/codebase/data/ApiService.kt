package firat.gurgur.codebase.data


import firat.gurgur.codebase.model.ResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters() : ResponseModel

}