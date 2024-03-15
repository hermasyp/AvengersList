package com.catnip.avengerslist.presentation.avengerdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.catnip.avengerslist.R
import com.catnip.avengerslist.data.model.Avenger
import com.catnip.avengerslist.databinding.FragmentAvengerDetailBinding

class AvengerDetailFragment : Fragment() {

    private lateinit var binding: FragmentAvengerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengerDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentData()

    }

    private fun getArgumentData() {
        val item = arguments?.getParcelable<Avenger>(EXTRAS_ITEM)
        Toast.makeText(requireContext(), item?.name, Toast.LENGTH_SHORT).show()
    }

    companion object{
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
    }

}