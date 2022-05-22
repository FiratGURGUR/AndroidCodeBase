package firat.gurgur.codebase.util.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImageFromUrl(imageview: ImageView, url : String?) {
        Glide.with(imageview.context).load(url).into(imageview)
    }

}