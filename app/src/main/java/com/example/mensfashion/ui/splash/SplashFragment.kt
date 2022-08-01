package com.example.mensfashion.ui.splash

import android.os.Bundle
import android.view.View
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun setViewBinding() = FragmentSplashBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO implement your code here
    }
}