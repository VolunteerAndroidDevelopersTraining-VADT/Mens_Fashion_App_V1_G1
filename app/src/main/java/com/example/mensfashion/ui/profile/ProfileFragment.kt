package com.example.mensfashion.ui.profile

import android.os.Bundle
import android.view.View
import com.example.mensfashion.R
import com.example.mensfashion.core.SecureSharedPreferences
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.databinding.FragmentProfileBinding
import com.example.mensfashion.utils.Constants


class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun setViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SecureSharedPreferences.save(true, Constants.IS_LOGIN)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignOut.setOnClickListener {
            SecureSharedPreferences.save(false, Constants.IS_LOGIN)
            navigateTo(R.id.action_homeFragment_to_loginFragment2)
        }

    }


}
