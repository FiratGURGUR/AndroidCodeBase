package firat.gurgur.codebase.ui.tab1

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import firat.gurgur.codebase.R
import firat.gurgur.codebase.base.BaseFragment
import firat.gurgur.codebase.databinding.FragmentTab1Child1Binding
import firat.gurgur.codebase.ui.tab1.adapter.CharacterAdapter


@AndroidEntryPoint
class Tab1Child1Fragment  : BaseFragment<FragmentTab1Child1Binding>(FragmentTab1Child1Binding::inflate) {

    private val viewModel: ApiViewModel by viewModels()
    lateinit var characterAdapter: CharacterAdapter

    override fun initView() {
        initAdapter()
        handleClicks()

        viewModel.getCharacterApiCall()
    }

    override fun initObservers() {
        viewModel.progressStatus.observe(viewLifecycleOwner){
            showLoading(it)
        }

        viewModel.characterList.observe(this, {
            characterAdapter.submitList(null)
            characterAdapter.submitList(it.results)
        })
    }


    private fun initAdapter(){
        characterAdapter = CharacterAdapter{
            viewModel.onCharacterItemClicked()
        }
        binding.characterRv.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        binding.characterRv.adapter = characterAdapter
        characterAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

    }


    private fun handleClicks() {
        viewModel.clickActions.observe(
            viewLifecycleOwner,
            { clickAction ->
                when (clickAction) {
                    is HomeClickActions.CharacterClicked ->
                        findNavController().navigate(R.id.action_tab1Child1Fragment_to_tab1Child2Fragment)
                }
            }
        )
    }


}