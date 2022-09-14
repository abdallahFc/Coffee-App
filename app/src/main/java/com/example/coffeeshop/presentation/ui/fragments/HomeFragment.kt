package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.presentation.ui.adapter.HomeAdapter
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.presentation.viewmodel.HomeViewModel
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.PersonalInfo
import com.example.coffeeshop.util.NetworkResult


class HomeFragment : Fragment(R.layout.fragment_home) {


    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRv)
        recyclerView.layoutManager = layoutManager
        var list: List<Product>
        homeViewModel.getAllProducts(PersonalInfo.getInstance().token.toString())
        homeViewModel.liveData.observe(viewLifecycleOwner) {
            it.let { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        list = response.data!!
                        adapter = HomeAdapter(list) {
                            onItemClicked(it)
                        }
                        recyclerView.adapter = adapter
                    }
                    is NetworkResult.Error -> Toast.makeText(
                        requireContext(),
                        response.message,
                        Toast.LENGTH_LONG
                    ).show()
                    else -> {}
                }

            }
        }
        val back = view.findViewById<ImageView>(R.id.arrow_back)
        back.setOnClickListener {
            activity?.onBackPressed()
        }
    }


    private fun onItemClicked(item: Product) {

        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToPreferencesFragment(
                item.name,
                item.price,
                item.image
            )
        )
    }
}