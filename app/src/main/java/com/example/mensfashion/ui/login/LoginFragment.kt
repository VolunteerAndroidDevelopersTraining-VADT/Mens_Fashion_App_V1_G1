package com.example.mensfashion.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.FragmentLoginBinding

class LoginFragment :BaseFragment<FragmentLoginBinding>() {
    override fun setViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
   private val loginViewModel:LoginViewModel by  viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewAnimation()
       binding.loginBtn onclick :: login

    }

    private fun login() {
        when(loginViewModel.isValid)
    }

    private fun setUpViewAnimation() {
    binding.cardCv.apply {
        createAnimation(this,300)
    }
     binding.userEmailLayout.apply {
        createAnimation(this,300)
     }
     binding.passwordLayout.apply {
          createAnimation(this,500)
     }
     binding.loginBtn.apply {
         createAnimation(this,700)
     }
     binding.tvForgettenPassword.apply {
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
}