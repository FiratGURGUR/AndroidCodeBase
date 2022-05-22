package firat.gurgur.codebase.model


import com.squareup.moshi.Json
import firat.gurgur.codebase.model.character.CharacterItemModel
import firat.gurgur.codebase.model.character.InfoModel


data class ResponseModel(
    @field:Json(name = "info")
    var info: InfoModel? = null,
    @field:Json(name = "results")
    var results: ArrayList<CharacterItemModel>? = null
)
