package com.catnip.avengerslist.presentation.avengerslist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.catnip.avengerslist.R
import com.catnip.avengerslist.base.ViewHolderBinder
import com.catnip.avengerslist.data.model.Avenger
import com.catnip.avengerslist.databinding.ItemAvengerBinding
import com.catnip.avengerslist.databinding.ItemAvengerGridBinding

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class AvengerGridItemViewHolder(
    private val binding: ItemAvengerGridBinding,
    private val listener: OnItemClickedListener<Avenger>
) : ViewHolder(binding.root), ViewHolderBinder<Avenger> {

    override fun bind(item: Avenger) {
        item.let {
            binding.ivAvengerPhoto.load(it.profilePictUrl) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvAvengerName.text = it.name
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}