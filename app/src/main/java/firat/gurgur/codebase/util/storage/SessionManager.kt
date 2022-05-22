package firat.gurgur.codebase.util.storage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import firat.gurgur.codebase.util.AppConstants.Companion.DARK_MODE_ENABLE
import javax.inject.Inject

class SessionManager @Inject constructor(private val preferences: SharedPreferences) {

    fun getTheme() = preferences.getInt(DARK_MODE_ENABLE, AppCompatDelegate.MODE_NIGHT_NO)

    fun setTheme(value: Int) {
        val editor = preferences.edit()
        editor.putInt(DARK_MODE_ENABLE, value)
        editor.apply()
    }
}