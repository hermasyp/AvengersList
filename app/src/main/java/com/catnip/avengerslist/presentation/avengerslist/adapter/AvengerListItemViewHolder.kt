package com.catnip.avengerslist.presentation.avengerslist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.catnip.avengerslist.R
import com.catnip.avengerslist.base.ViewHolderBinder
import com.catnip.avengerslist.data.model.Avenger
import com.catnip.avengerslist.databinding.ItemAvengerBinding

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class AvengerListItemViewHolder(
    private val binding: ItemAvengerBinding
) : ViewHolder(binding.root), ViewHolderBinder<Avenger> {

    override fun bind(item: Avenger) {
        item.let {
            binding.ivAvengerPhoto.load(it.profilePictUrl) {
                //crossfade, gambar muncul secara perlahan
                crossfade(true)
                // error , Gambar fallback ketika gambar gagal di load
                error(R.mipmap.ic_launcher)
            }
            binding.tvAvengerName.text = it.name
            binding.tvAvengerPower.text = it.power
        }
    }
}