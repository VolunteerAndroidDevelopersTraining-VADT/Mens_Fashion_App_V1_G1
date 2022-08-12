package com.example.mensfashion.ui.splash

import android.os.Bundle
import android.view.View
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.databinding.FragmentSplashBinding
import com.example.mensfashion.utils.Constants

class SplashFragment : BaseFragment<FragmentSplashBinding>() {


    override fun setViewBinding() = FragmentSplashBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            if (isLogin()) {
                // navController.navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                // navController.navigate(R.id.action_splashFragment_to_loginFragment)
            }
            navigateTo(action = R.id.action_splashFragment_to_loginFragment2)
        }


    }


    private fun isLogin(): Boolean {
        return pref.retrieve<Boolean>(Constants.IS_LOGIN) == true
    }
}