package com.example.coffeeshop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R

class PreferencesFragment : Fragment(R.layout.fragment_preferences) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preferences, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefBtn=view.findViewById<Button>(R.id.btn_add_to_cart)
        prefBtn.setOnClickListener {
            findNavController().navigate(com.example.coffeeshop.PreferencesFragmentDirections.actionPreferencesFragmentToCartFragment())
        }
    }


}