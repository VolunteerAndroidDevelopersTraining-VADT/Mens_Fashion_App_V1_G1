package com.example.mensfashion.ui.home

import android.os.Bundle
import com.example.mensfashion.core.SecureSharedPreferences
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentHomeBinding
import com.example.mensfashion.utils.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun setViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SecureSharedPreferences.save(true, Constants.IS_LOGIN)


    }

}