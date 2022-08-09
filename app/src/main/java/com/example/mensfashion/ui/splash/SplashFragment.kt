package com.example.mensfashion.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding,SplashViewModel>() {
    private  val splashViewModel:SplashViewModel by viewModels()
    override fun setViewBinding() = FragmentSplashBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.btnSplash.setOnClickListener {

         }

    }

    override fun initializeViewModel(): SplashViewModel = splashViewModel
}