package com.example.coffeeshop.presentation.ui.fragments
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.AddToCart


class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({
            goOnboarding()
        }, 3000)
        super.onViewCreated(view, savedInstanceState)

    }

    private fun goOnboarding(){
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnboardingFragment())
    }

}