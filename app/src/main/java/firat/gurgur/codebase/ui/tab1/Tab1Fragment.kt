package firat.gurgur.codebase.ui.tab1

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import firat.gurgur.codebase.R
import firat.gurgur.codebase.base.BaseFragment
import firat.gurgur.codebase.databinding.FragmentTab1Binding

@AndroidEntryPoint
class Tab1Fragment  : BaseFragment<FragmentTab1Binding>(FragmentTab1Binding::inflate){

    override fun initView() {
        binding.gotab1Child1.setOnClickListener{
            findNavController().navigate(R.id.action_tab1Fragment_to_tab1Child1Fragment)
        }
    }

    override fun initObservers() {

    }


}