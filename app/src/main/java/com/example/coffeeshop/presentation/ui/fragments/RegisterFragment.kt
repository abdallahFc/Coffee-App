package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.RegisterRequest
import com.example.coffeeshop.util.NetworkResult
import com.example.coffeeshop.presentation.viewmodel.RegisterViewModel


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etFullName = view.findViewById<EditText>(R.id.tx_fullName)
        val etEmail = view.findViewById<EditText>(R.id.tx_email)
        val etPass = view.findViewById<EditText>(R.id.tx_pass)
        val etcPass = view.findViewById<EditText>(R.id.tx_conPass)
        val btn = view.findViewById<Button>(R.id.btn_register)
        btn.setOnClickListener {
            val email = etEmail?.text.toString()
            val password = etPass?.text.toString()
            val username = etFullName?.text.toString()
            val repeatedPass = etcPass?.text.toString()
            if (email.isEmpty() || password.isEmpty() || username.isEmpty() || repeatedPass.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "please fill all required fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password != repeatedPass) {
                Toast.makeText(
                    requireContext(),
                    "password field is not equal to repeated password field",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                registerViewModel.register(RegisterRequest(username, email, password))
                registerViewModel.liveData.observe(viewLifecycleOwner) {
                    it?.let { response ->
                        when (response) {
                            //
                            is NetworkResult.Success -> findNavController().navigate(
                                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                            )
                            is NetworkResult.Error -> Toast.makeText(
                                requireContext(),
                                "user: ${response.message}",
                                Toast.LENGTH_LONG
                            ).show()
                            else -> {

                            }
                        }
                    }
                }
            }
        }
    }

}