package firat.gurgur.codebase.util.extensions

import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import firat.gurgur.codebase.R

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, length).show()
}

fun Fragment.toast(@StringRes messageResId: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, messageResId, length).show()
}

fun Fragment.toastNetworkResult(
    result: Boolean,
    successMsg: String?,
    errorMsg: String? = resources.getString(
        R.string.generic_error
    )
) {
    if (result && !successMsg.isNullOrEmpty()) toast(successMsg)
    else errorMsg?.let { toast(it) }
}

fun Fragment.makeSnackbar(snackMsg: String, buttonMsg: String?, onButtonClicked: () -> Unit) {
    try {
        Snackbar.make(requireView(), snackMsg, Snackbar.LENGTH_LONG).apply {
            buttonMsg?.let { setAction(it) { onButtonClicked() } }
            show()
        }
    }catch (ex : Exception){
        Log.e("Ex",ex.message.toString())
    }
}





