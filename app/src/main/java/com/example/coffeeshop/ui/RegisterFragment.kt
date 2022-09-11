package com.example.coffeeshop.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R


class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginTx=view.findViewById<TextView>(R.id.tx_goLogin)
        loginTx.setOnClickListener{
            findNavController().navigate(
                com.example.coffeeshop.RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            )
        }
    }

}