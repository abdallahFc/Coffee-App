package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.presentation.ui.adapter.CartAdapter

import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.AddToCart
import com.example.coffeeshop.data.model.CartItem
import java.util.ArrayList


class CartFragment : Fragment(R.layout.fragment_cart) {
    private lateinit var adapter: CartAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        var list: ArrayList<CartItem>
        list= AddToCart.getInstance()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productcartRv)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CartAdapter(list)
        recyclerView.adapter = adapter
        val back = view.findViewById<ImageView>(R.id.arrow_back)
        back.setOnClickListener {
            getActivity()?.onBackPressed()
        }
    }

}