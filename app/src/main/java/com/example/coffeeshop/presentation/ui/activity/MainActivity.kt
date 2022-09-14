package com.example.coffeeshop.presentation.ui.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.PersonalInfo
import com.example.coffeeshop.presentation.ui.fragments.CartFragment
import com.example.coffeeshop.presentation.ui.fragments.HomeFragment
import com.example.coffeeshop.presentation.ui.fragments.ProfileFragment
import com.example.coffeeshop.presentation.viewmodel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val hideBottomNav = listOf(R.id.splashFragment, R.id.loginFragment, R.id.registerFragment,R.id.onboardingFragment)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
        val navController = navHostFragment!!.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
       if (destination.id in hideBottomNav)
        { bottomNav.visibility = View.GONE }
        else { bottomNav.visibility = View.VISIBLE} }
        bottomNav.setupWithNavController(navController)

    }
}