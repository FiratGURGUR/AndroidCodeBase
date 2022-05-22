package firat.gurgur.codebase.ui.tab1.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import firat.gurgur.codebase.base.BaseViewHolder
import firat.gurgur.codebase.databinding.ItemCharacterBinding
import firat.gurgur.codebase.model.character.CharacterItemModel


class CharacterItemViewHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemCharacterBinding>(
    binding = ItemCharacterBinding.inflate(inflater, parent, false)
) {

    fun bind(
        character : CharacterItemModel,
        characterClickCallback : ((CharacterItemModel) -> Unit)? = null
    ) {
        with(binding) {
            binding.character = character
            binding.characterLayout.setOnClickListener{
                characterClickCallback?.invoke(character)
            }
            executePendingBindings()
        }
    }


}
