package com.example.mensfashion.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentLoginBinding
import com.example.mensfashion.ui.MainActivity

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var passward: String
    private lateinit var email: String

    override fun setViewBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            email = binding.etEmail.text.toString()
            passward = binding.passward.text.toString()
            loginViewModel.userLogin(email, passward)
            loginViewModel.loginResult.observe(viewLifecycleOwner) { result ->
                when (result) {
                    "invalid Email!" -> binding.layoutEmail.error = "invalid Email!"
                    "required"->binding.layoutPass.error= "required"
                    else->{
                        findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)
                    }
                }

            }
        }
        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment2)
        }
    }


}