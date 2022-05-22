package firat.gurgur.codebase.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageUrl(imageUrl: String?) {
    val url = imageUrl ?: return
    Glide.with(context)
        .load(url)
        .into(this)
}