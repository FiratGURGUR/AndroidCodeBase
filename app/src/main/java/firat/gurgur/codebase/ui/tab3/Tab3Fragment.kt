package firat.gurgur.codebase.ui.tab3


import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import firat.gurgur.codebase.R
import firat.gurgur.codebase.base.BaseFragment
import firat.gurgur.codebase.databinding.FragmentTab3Binding

@AndroidEntryPoint
class Tab3Fragment  :  BaseFragment<FragmentTab3Binding>(FragmentTab3Binding::inflate) {

    override fun initView() {
        binding.gotab3child1.setOnClickListener{
            findNavController().navigate(R.id.action_tab3Fragment_to_tab3Child1Fragment)
        }
    }

    override fun initObservers() {

    }


}