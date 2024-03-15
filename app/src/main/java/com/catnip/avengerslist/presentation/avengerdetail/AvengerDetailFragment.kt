package com.catnip.avengerslist.presentation.avengerdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catnip.avengerslist.R
import com.catnip.avengerslist.databinding.FragmentAvengerDetailBinding

class AvengerDetailFragment : Fragment() {

    private lateinit var binding : FragmentAvengerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengerDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}