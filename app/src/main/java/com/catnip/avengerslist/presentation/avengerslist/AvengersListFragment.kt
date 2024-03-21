package com.catnip.avengerslist.presentation.avengerslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.catnip.avengerslist.R
import com.catnip.avengerslist.data.model.Avenger
import com.catnip.avengerslist.databinding.FragmentAvengersListBinding
import com.catnip.avengerslist.presentation.avengerdetail.AvengerDetailFragment
import com.catnip.avengerslist.presentation.avengerslist.adapter.AvengersAdapter
import com.catnip.avengerslist.presentation.avengerslist.adapter.OnItemClickedListener

class AvengersListFragment : Fragment() {

    private lateinit var binding: FragmentAvengersListBinding
    private var adapter: AvengersAdapter? = null

    //init viewmodel
    private val viewModel: AvengersListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengersListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeGridMode()
        setClickAction()
    }

    private fun observeGridMode() {
        viewModel.isUsingGridMode.observe(viewLifecycleOwner) { isUsingGridMode ->
            bindAvengersList(isUsingGridMode)
            setButtonText(isUsingGridMode)
        }
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            viewModel.changeListMode()
        }
    }

    private fun setButtonText(usingGridMode: Boolean) {
        binding.btnChangeListMode.setText(if (usingGridMode) R.string.text_list_mode else R.string.text_grid_mode)
    }

    private fun bindAvengersList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) AvengersAdapter.MODE_GRID else AvengersAdapter.MODE_LIST
        adapter = AvengersAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Avenger> {
                override fun onItemClicked(item: Avenger) {
                    //navigate to detail
                    navigateToDetail(item)
                }
            })
        binding.rvAvengerList.apply {
            adapter = this@AvengersListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(viewModel.getAvengersList())
    }

    private fun navigateToDetail(item: Avenger) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(AvengerDetailFragment.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_avengersListFragment_to_avengerDetailFragment, bundle)
    }

}