package com.example.mensfashion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mensfashion.R
import com.example.mensfashion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.navHostFragment)
        navController.addOnDestinationChangedListener{ _, destination, _ ->

            when(destination.id){
                R.id.splashFragment -> hideBottomNav()

                else ->showBottomNav()
          }
        }
        binding.bottomNavigationView.setupWithNavController(navController)


    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun showBottomNav() {
        binding. bottomNavigationView.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding. bottomNavigationView.visibility= View.GONE

    }
}