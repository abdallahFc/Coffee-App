package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.presentation.ui.adapter.CartAdapter
import com.example.coffeeshop.presentation.viewmodel.CartViewModel
import com.example.coffeeshop.R


class CartFragment : Fragment(R.layout.fragment_cart) {
    private val cartViewModel: CartViewModel by viewModels()
    private lateinit var adapter: CartAdapter
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productcartRv)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CartAdapter(cartViewModel.getAdapterList())

        recyclerView.adapter = adapter
    }

}