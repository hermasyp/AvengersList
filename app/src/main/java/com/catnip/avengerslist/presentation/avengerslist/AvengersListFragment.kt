package com.catnip.avengerslist.presentation.avengerslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catnip.avengerslist.databinding.FragmentAvengersListBinding

class AvengersListFragment : Fragment() {

    private lateinit var binding: FragmentAvengersListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengersListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}