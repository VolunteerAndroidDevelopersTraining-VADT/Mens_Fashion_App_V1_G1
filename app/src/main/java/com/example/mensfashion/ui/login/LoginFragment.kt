package com.example.mensfashion.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(){


    val  loginViewModel:LoginViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun setViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)


}