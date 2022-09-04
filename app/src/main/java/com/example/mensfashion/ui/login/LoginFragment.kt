package com.example.mensfashion.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.core.translationXAnimation
import com.example.mensfashion.core.translationYAnimation
import com.example.mensfashion.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var passward: String
    private lateinit var email: String

    override fun setViewBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
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
                    "required" -> binding.layoutPass.error = "required"
                    else -> {
                        navigateTo(R.id.action_loginFragment2_to_homeFragment)
                    }
                }

            }
        }
        binding.tvSignup.setOnClickListener {
            navigateTo(R.id.action_loginFragment2_to_registerFragment2)
        }
        setUpViewAnimation()
    }


    private fun setUpViewAnimation() {
        binding.imgLogin.translationYAnimation(200)
        binding.welcomeText.translationXAnimation(200)
        binding.layoutEmail.translationXAnimation(200)
        binding.layoutPass.translationXAnimation(350)
        binding.forgetPassword.translationXAnimation(400)
        binding.btnLogin.translationXAnimation(550)
        binding.tvNot.translationXAnimation(600)
        binding.tvSignup.translationXAnimation(700)

    }

}