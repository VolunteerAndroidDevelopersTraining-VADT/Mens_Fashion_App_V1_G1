package com.example.mensfashion.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.mensfashion.R
import com.example.mensfashion.core.SecureSharedPreferences
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun setViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SecureSharedPreferences.save(true, "loggedIn")


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignOut.setOnClickListener {

            SecureSharedPreferences.save(false, "loggedIn")
            navigateTo(R.id.action_homeFragment_to_loginFragment2)
        }
    }
}