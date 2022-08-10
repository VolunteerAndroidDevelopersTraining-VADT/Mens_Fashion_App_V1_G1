package com.example.mensfashion.ui.registeration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentRegisterationBinding

class RegistrationFragment :BaseFragment<FragmentRegisterationBinding,RegisterationViewModel>(){
  private val registrationViewModel:RegisterationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setViewBinding(): FragmentRegisterationBinding = FragmentRegisterationBinding.inflate(layoutInflater)

    override fun initializeViewModel(): RegisterationViewModel =registrationViewModel
}