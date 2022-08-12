package com.example.mensfashion.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.example.mensfashion.App.Companion.pref
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.FragmentLoginBinding
import com.example.mensfashion.utils.Constants

class LoginFragment :BaseFragment<FragmentLoginBinding>() {
    override fun setViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
   private val loginViewModel:LoginViewModel by  viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           binding.vm=loginViewModel
        clearErrorMessage()
        setUpViewAnimation()
        binding.loginBtn onclick :: login
        binding.tvForgettenPassword onclick :: forgottenPassword


    }


  private fun forgottenPassword(){

  }
    private fun login() {
        showLoading()
        loginViewModel.login()
        loginViewModel.loginResponse.observe(viewLifecycleOwner){ result->
           hiddenLoading()
            when(result){
                is LoginViewModel.LoginResult.InvalidResult->{
                    invalidLoginResult(result)
                 }
                LoginViewModel.LoginResult.LoginFailure -> {
                     loginFailed()
                }
                LoginViewModel.LoginResult.LoginSuccessful -> {
                    userExist()
                }
            }
        }



        }

    private fun loginFailed() {
         hiddenLoading()
        //and will handle failed reason
        binding.textError.visibility = View.VISIBLE
    }
     //which of two method is better
    private fun invalidLoginResult(result: LoginViewModel.LoginResult.InvalidResult) {
        hiddenLoading()
        when (result.loginError) {
            LoginViewModel.LoginError.EmptyEmail -> {
              binding.userEmailLayout.error=getString(R.string.required)
            }
            LoginViewModel.LoginError.EmptyPassword -> {
               binding.passwordLayout.error=getString(R.string.required)
            }
            LoginViewModel.LoginError.EmailError,
            LoginViewModel.LoginError.PasswordError -> {
                binding.textError.visibility = View.VISIBLE
                binding.userEmailLayout.boxStrokeColor=resources.getColor(R.color.red)
                binding.passwordLayout.boxStrokeColor=resources.getColor(R.color.red)


            }
        }
    }
    private fun invalidLoginResult1(result: LoginViewModel.LoginResult.InvalidResult) {
            hiddenLoading()
            when (result.loginError) {
                LoginViewModel.LoginError.EmptyEmail -> {
                binding.userEmailLayout.error=getString(R.string.required)
            }
            LoginViewModel.LoginError.EmptyPassword -> {
                binding.passwordLayout.error=getString(R.string.required)
            }
            LoginViewModel.LoginError.EmailError->  {
                binding.userEmailLayout.error=getString(R.string.invalid_email)
                binding.userEmailLayout.boxStrokeColor=resources.getColor(R.color.red)

            }
            LoginViewModel.LoginError.PasswordError -> {
                   binding.passwordLayout.error=getString(R.string.invalid_password)
                binding.passwordLayout.boxStrokeColor=resources.getColor(R.color.red)

            }
           }
    }


    private fun userExist(){
        hiddenLoading()
        navController.navigate(R.id.action_registrationFragment_to_homeFragment)
        pref.save(true,Constants.IS_LOGIN)
    }

    private fun showLoading() {
        binding.loginBtn.isEnabled=false
        binding.progressViewStub.viewStub?.visibility=View.VISIBLE

    }
// dont work
    private fun hiddenLoading() {
        binding.loginBtn.isEnabled=true
        binding.progressViewStub.viewStub?.visibility=View.GONE

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

    private fun clearErrorMessage() {

        binding.passwordLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                hiddenLoading()
                binding.passwordLayout.error = null
                binding.textError.visibility=View.GONE
            }
        })
        binding.userEmailLayout.editText?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                hiddenLoading()
                binding.userEmailLayout.error=null
                binding.textError.visibility=View.GONE
            }
        })



    }

}