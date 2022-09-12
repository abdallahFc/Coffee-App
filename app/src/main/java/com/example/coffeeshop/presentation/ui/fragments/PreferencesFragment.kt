package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R

class PreferencesFragment : Fragment(R.layout.fragment_preferences) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefBtn=view.findViewById<Button>(R.id.btn_add_to_cart)
        val smallCoffe=view.findViewById<ImageView>(R.id.iv_coffee_small)
        val midCoffe=view.findViewById<ImageView>(R.id.iv_coffee_med)
        val largeCoffe=view.findViewById<ImageView>(R.id.iv_coffe_large)
        prefBtn.setOnClickListener {
            findNavController().navigate(com.example.coffeeshop.presentation.ui.PreferencesFragmentDirections.actionPreferencesFragmentToCartFragment())
        }
        smallCoffe.setOnClickListener{
            smallCoffe.setColorFilter(R.color.black)
        }
    }


}