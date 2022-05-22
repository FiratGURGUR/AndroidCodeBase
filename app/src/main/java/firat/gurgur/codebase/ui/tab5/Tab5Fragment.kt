package firat.gurgur.codebase.ui.tab5


import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.AndroidEntryPoint
import firat.gurgur.codebase.base.BaseFragment
import firat.gurgur.codebase.databinding.FragmentTab5Binding
import firat.gurgur.codebase.util.AppConstants.Companion.MODE_NIGHT_NO
import firat.gurgur.codebase.util.AppConstants.Companion.MODE_NIGHT_YES

@AndroidEntryPoint
class Tab5Fragment()  : BaseFragment<FragmentTab5Binding>(FragmentTab5Binding::inflate) {


    override fun initView() {
        checkTheme()

        with(binding){
            darkModeSwitch.setOnClickListener{
                when {
                    darkModeSwitch.isChecked -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        sessionManager.setTheme(MODE_NIGHT_YES)
                    }
                    else -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        sessionManager.setTheme(MODE_NIGHT_NO)
                    }
                }
            }
        }
    }

    override fun initObservers() {

    }


    private fun checkTheme() {
        binding.darkModeSwitch.isChecked = sessionManager.getTheme() == MODE_NIGHT_YES
    }

}