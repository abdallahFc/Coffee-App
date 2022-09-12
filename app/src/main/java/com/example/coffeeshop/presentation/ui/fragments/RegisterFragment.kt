package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.RegisterRequest
import com.example.coffeeshop.util.NetworkResult
import com.example.coffeeshop.presentation.viewmodel.RegisterViewModel


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val registerViewModel:RegisterViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModel.register(RegisterRequest("Seif","seif2@gmail.com","123456abcdew"))
        /*val loginTx=view.findViewById<TextView>(R.id.tx_goLogin)
        loginTx.setOnClickListener{
            findNavController().navigate(

                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            )
        }*/
        registerViewModel.liveData.observe(viewLifecycleOwner){
            it?.let { response ->
                when(response){
                    is NetworkResult.Success -> Toast.makeText(requireContext(), "user: ${response.data.toString()}", Toast.LENGTH_LONG).show()
                    is NetworkResult.Error -> Toast.makeText(requireContext(), "user: ${response.message}", Toast.LENGTH_LONG).show()
                    else ->{

                    }
                }
            }
        }

    }

}