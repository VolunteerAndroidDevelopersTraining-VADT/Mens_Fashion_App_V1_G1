package com.example.mensfashion.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mensfashion.R
import com.example.mensfashion.core.SecureSharedPreferences
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentSplashBinding
import com.example.mensfashion.ui.MainActivity

class SplashFragment : BaseFragment<FragmentSplashBinding>() {


    override fun setViewBinding(): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShopeNow.setOnClickListener {

            val isLoggedIn = SecureSharedPreferences.retrieve<Boolean>("loggedIn")
            if (isLoggedIn == true) {
               findNavController().navigate(R.id.action_splashFragment2_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment2_to_loginFragment2)
            }
        }
    }
}
