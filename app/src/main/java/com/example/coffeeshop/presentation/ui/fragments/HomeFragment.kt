package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.presentation.ui.adapter.HomeAdapter
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.presentation.viewmodel.HomeViewModel
import com.example.coffeeshop.R


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRv)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HomeAdapter(homeViewModel.getAdapterList()){
            onItemClicked(it)
        }
        recyclerView.adapter = adapter
    }


    private fun onItemClicked(item: Product)
    {
        findNavController().navigate(com.example.coffeeshop.presentation.ui.HomeFragmentDirections.actionHomeFragmentToPreferencesFragment())
        Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()

    }
}