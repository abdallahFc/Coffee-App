package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.presentation.ui.adapter.HomeAdapter
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.presentation.viewmodel.HomeViewModel
import com.example.coffeeshop.R
import com.example.coffeeshop.util.NetworkResult


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRv)
        recyclerView.layoutManager = layoutManager
       // recyclerView.setHasFixedSize(true)
       /* adapter = HomeAdapter(homeViewModel.getAdapterList()){
            onItemClicked(it)
        }*/
       //    recyclerView.adapter = adapter
        homeViewModel.getAllProducts("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXplbSIsImV4cCI6MTY2MzEwNjgyMSwiaWF0IjoxNjYzMDcwODIxfQ.sVF2thYoRppPb5pF4V_Na0NUwKOnFWZ5kMJVbPfClVs")
         homeViewModel.liveData.observe(viewLifecycleOwner){
          it.let{response->
              when(response){
                  is NetworkResult.Success ->Toast.makeText(requireContext(),"success",Toast.LENGTH_LONG).show()
                  is NetworkResult.Error -> Toast.makeText(requireContext(),response.message,Toast.LENGTH_LONG).show()
                  else -> {}
              }

          }
         }
    }


    private fun onItemClicked(item: Product)
    {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPreferencesFragment())
        Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()

    }
}