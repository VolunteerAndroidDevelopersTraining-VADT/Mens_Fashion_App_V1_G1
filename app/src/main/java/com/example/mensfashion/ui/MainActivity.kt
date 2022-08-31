package com.example.mensfashion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mensfashion.R
import com.example.mensfashion.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragmentContainerView2)
        actionBar?.hide()

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.splashFragment    -> hideBottomNav()
                R.id.loginFragment     -> hideBottomNav()
                R.id.registerFragment2 -> hideBottomNav()
                R.id.detailsFragment->hideBottomNav()
                else -> showBottomNav()
            }
        }
        binding.bottomNavigationView.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun showBottomNav() {
        binding.bottomNavigationView.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding.bottomNavigationView.visibility = View.GONE

    }
}