package com.example.mensfashion.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mensfashion.R
import com.example.mensfashion.databinding.FragmentLoginBinding
import com.example.mensfashion.ui.MainActivity

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var passward: String
    private lateinit var email: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
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
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intent)
                    }
                }

            }
        }
        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}