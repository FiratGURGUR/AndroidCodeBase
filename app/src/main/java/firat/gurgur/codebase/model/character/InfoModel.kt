package firat.gurgur.codebase.model.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfoModel(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
) : Parcelable