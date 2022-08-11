package com.example.mensfashion.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentRegisterBinding
import com.example.mensfashion.ui.MainActivity

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var userName: String
    private lateinit var passward: String
    private lateinit var email: String

    override fun setViewBinding(): FragmentRegisterBinding {
        return  FragmentRegisterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignup.setOnClickListener {
            userName = binding.etUserName.text.toString()
            email = binding.etEmail.text.toString()
            passward = binding.etPass.text.toString()
            registerViewModel.registerUser(userName, email, passward)
            registerViewModel.registerResult.observe(viewLifecycleOwner) { result ->
                when (result) {
                    "required" -> {
                        binding.layoutUserName.error = "required"
                    }
                    "invalid Email!" -> {
                        binding.layoutEmail.error = "invalid Email!"
                      //  binding.layoutEmail.requestFocus()
                    }
                    "invalid passward!" -> {
                        binding.layoutPass.error = "invalid passward!"
                       // binding.layoutPass.requestFocus()
                    }
                    else -> {
                        Toast.makeText(
                            requireContext(),
                            " Done Successfully\uD83C\uDF89",
                            Toast.LENGTH_SHORT
                        ).show()
                        findNavController().navigate(R.id.action_registerFragment2_to_homeFragment)
                    }


                }
            }
        }
    }


}