package com.example.mensfashion.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.FragmentRegistrationBinding
import com.example.mensfashion.utils.isEmail
import com.example.mensfashion.utils.isPassword
import com.example.mensfashion.utils.isPhone
import com.example.mensfashion.utils.isUserName
import com.google.android.material.snackbar.Snackbar

class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding
    private lateinit var userName: String
    private lateinit var phone: String
    private lateinit var email: String
    private lateinit var password: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.onclick {
            userName = binding.etUserName.text.toString()
            phone = binding.etPhoneNumber.text.toString()
            email = binding.etEmail.text.toString()
            password = binding.etPassword.text.toString()
            checkUserInput()
        }
        binding.tvLogin.onclick {
            // navigate to login fragment
        }

    }

    private fun checkUserInput() {
        if (userName.isUserName() && phone.isPhone() && email.isEmail() && password.isPassword()) {
            showSnackBar("Account Created Successfully")
        } else {
            if (!userName.isUserName())
                showSnackBar("Please Enter Your Username!")
            else if (!phone.isPhone())
                showSnackBar("Please Enter Your Phone Number!")
            else if (!email.isEmail())
                showSnackBar("Please Enter Your Email!")
            else if (!password.isPassword())
                showSnackBar("Please Enter a valid Password!")
        }

    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }
}