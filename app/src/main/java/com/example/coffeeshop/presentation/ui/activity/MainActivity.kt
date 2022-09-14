package com.example.coffeeshop.presentation.ui.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.coffeeshop.R
import com.example.coffeeshop.presentation.ui.fragments.CartFragment
import com.example.coffeeshop.presentation.ui.fragments.HomeFragment
import com.example.coffeeshop.presentation.ui.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
        val navController = navHostFragment!!.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (listOf(R.id.splashFragment, R.id.loginFragment, R.id.registerFragment,R.id.onboardingFragment).contains(
                    destination.id
                )
            ) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }

        bottomNav.setOnItemSelectedListener { item ->
            bottomNav.menu.findItem(item.itemId).isChecked = true
            var fragment: Fragment? = null
            if (item.itemId == R.id.home)
                fragment = HomeFragment()
            else if (item.itemId == R.id.profile)
                fragment = ProfileFragment()
            else if (item.itemId == R.id.addProduct)
                fragment = CartFragment()

            if (fragment != null) {
                showFragment(fragment)
            }
            false
        }
    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView,fragment)
            .commit()
    }
}