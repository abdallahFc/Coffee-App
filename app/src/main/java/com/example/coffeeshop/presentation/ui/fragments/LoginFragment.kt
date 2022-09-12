package com.example.coffeeshop.presentation.ui.fragments
import android.net.Network
import android.os.Bundle
import android.view.View
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
    private val loginViewModel:LoginViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginBtn=view.findViewById<TextView>(R.id.login_btn)
        /*loginBtn.setOnClickListener{
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            )
        }*/
        loginViewModel.login(LoginRequest("user0111","pccc"))

        loginViewModel.liveData.observe(viewLifecycleOwner){
            it.let { response ->
                when(response){
                    is NetworkResult.Success ->Toast.makeText(requireContext(), "user: $response", Toast.LENGTH_LONG).show()
                    is NetworkResult.Error ->Toast.makeText(requireContext(), "error: ${response.message}", Toast.LENGTH_LONG).show()
                    else ->{}
                }

            }
        }

    }

}