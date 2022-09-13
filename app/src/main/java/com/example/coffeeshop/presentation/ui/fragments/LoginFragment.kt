package com.example.coffeeshop.presentation.ui.fragments

import android.net.Network
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.LoginRequest
import com.example.coffeeshop.presentation.viewmodel.LoginViewModel
import com.example.coffeeshop.util.NetworkResult

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etUserName = view.findViewById<EditText>(R.id.username)
        val etPass = view.findViewById<EditText>(R.id.passwordETLogin)
        val loginBtn = view.findViewById<TextView>(R.id.login_btn)
        val back = view.findViewById<ImageView>(R.id.arrow_back)
        val goRegister = view.findViewById<TextView>(R.id.tx_register)
        loginBtn.setOnClickListener {
            val password = etPass?.text.toString()
            val username = etUserName?.text.toString()
            if (password.isEmpty() || username.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "please fill all required fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                loginViewModel.login(LoginRequest(username, password))
                loginViewModel.liveData.observe(viewLifecycleOwner) {
                    it.let { response ->
                        when (response) {
                            is NetworkResult.Success -> findNavController().navigate(
                                LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                            )
                            is NetworkResult.Error -> Toast.makeText(
                                requireContext(),
                                "error: ${response.message}",
                                Toast.LENGTH_LONG
                            ).show()
                            else -> {}
                        }

                    }
                }

            }
        }
        back.setOnClickListener {
            getActivity()?.onBackPressed();
        }
        goRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }


    }

}