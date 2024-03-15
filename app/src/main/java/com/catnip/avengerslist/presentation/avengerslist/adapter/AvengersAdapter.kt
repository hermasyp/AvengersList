package com.catnip.avengerslist.presentation.avengerslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.catnip.avengerslist.base.ViewHolderBinder
import com.catnip.avengerslist.data.model.Avenger
import com.catnip.avengerslist.databinding.ItemAvengerBinding
import com.catnip.avengerslist.databinding.ItemAvengerGridBinding

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class AvengersAdapter(private val listMode: Int = MODE_LIST) :
    RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this, object : DiffUtil.ItemCallback<Avenger>() {
            override fun areItemsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
                //membandingkan apakah item tersebut sama
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
                // yang dibandingkan adalah kontennya
                return oldItem.hashCode() == newItem.hashCode()
            }

        }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //membuat instance of view holder
        return if (listMode == MODE_GRID) AvengerGridItemViewHolder(
            ItemAvengerGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) else {
            AvengerListItemViewHolder(
                ItemAvengerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<Avenger>).bind(asyncDataDiffer.currentList[position])
    }
}