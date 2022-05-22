package firat.gurgur.codebase.ui.tab1.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import firat.gurgur.codebase.base.BaseListAdapter
import firat.gurgur.codebase.model.character.CharacterItemModel
import firat.gurgur.codebase.ui.tab1.adapter.viewholder.CharacterItemViewHolder

class CharacterAdapter(
    private val characterClickCallback: ((CharacterItemModel) -> Unit)?
) : BaseListAdapter<CharacterItemModel>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterItemViewHolder -> {
                holder.bind(
                    character = getItem(position),
                    characterClickCallback = characterClickCallback
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CharacterItemViewHolder(parent, inflater)
    }

}
