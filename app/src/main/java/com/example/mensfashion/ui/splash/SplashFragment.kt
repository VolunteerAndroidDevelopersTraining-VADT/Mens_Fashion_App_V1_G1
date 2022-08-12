package com.example.mensfashion.ui.splash

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentSplashBinding
import com.example.mensfashion.utils.Constants
import java.lang.invoke.ConstantCallSite

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private  val splashViewModel:SplashViewModel by viewModels()
    override fun setViewBinding() = FragmentSplashBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.btnSplash.setOnClickListener {
           if (isLogin()){
                //navController.navigate(R.id.action_splashFragment_to_homeFragment)
           }
           else{
               navController.navigate(R.id.action_splashFragment_to_registrationFragment)

           }
             navController.navigate(R.id.action_splashFragment_to_registrationFragment)

         }


    }


    private fun isLogin():Boolean{
        return pref.retrieve<Boolean>(Constants.IS_LOGIN)==true
    }
}