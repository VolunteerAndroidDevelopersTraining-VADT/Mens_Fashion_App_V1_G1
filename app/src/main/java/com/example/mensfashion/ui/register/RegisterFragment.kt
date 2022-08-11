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


class RegisterFragment : BaseFragment<FragmentRegisterBinding,>() {
   private val registerViewModel:RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewAnimation()
    }

    private fun setUpViewAnimation() {
        binding.cardCv.apply {
            createAnimation(this,300)
        }
        binding.emailLayout.apply {
            createAnimation(this,300)
        }
        binding.passwordLayout.apply {
            createAnimation(this,500)
        }

        binding.registerBtn.apply {
            createAnimation(this,900)
        }
        binding.userNameLayout.apply {
            createAnimation(this,500)


        }
    }

    private fun createAnimation(view: View,startDelay:Long) {
        view.apply {
            translationX=800f
            alpha=0f
            animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(startDelay).start()
        }
    }
    override fun setViewBinding(): FragmentRegisterBinding = FragmentRegisterBinding.inflate(layoutInflater)

}