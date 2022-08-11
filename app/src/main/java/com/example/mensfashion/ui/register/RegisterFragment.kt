package com.example.mensfashion.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentRegisterBinding


class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
   private val registerViewModel:RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setViewBinding(): FragmentRegisterBinding = FragmentRegisterBinding.inflate(layoutInflater)

}