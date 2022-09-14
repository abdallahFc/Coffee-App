@file:Suppress("DEPRECATION")

package com.example.coffeeshop.presentation.ui.fragments
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R


class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
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