package com.example.mensfashion.ui.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.core.onclick
import com.example.mensfashion.core.translationXAnimation
import com.example.mensfashion.core.translationXRightAnimation
import com.example.mensfashion.databinding.FragmentRegisterBinding
import com.example.mensfashion.utils.Constants
import com.example.mensfashion.utils.ResponseResult

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun setViewBinding(): FragmentRegisterBinding {
        return  FragmentRegisterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel=registerViewModel
        setUpViewAnimation()
        clearErrorMessage()
        binding.btnRegister onclick ::register
        binding.tvLogin onclick :: login


}

    private fun login() {

  navigateTo(R.id.action_registerFragment2_to_loginFragment)
    }

    /**
     * observe on response return when user try to
     * register and handle result
     */
    private fun register() {

        registerViewModel.register()
        registerViewModel.registerResponseResult.observe(viewLifecycleOwner){
            it?.let {
                registerViewModel.setLoading.set(false)
                userRegister()
            }

        }
    }

    /**
     * handle state of failed to register user
     */
    private fun registerFailed() {

    }


    /**
     *  navigate to home when user register
     * save user as login
     */
    private fun userRegister(){
       navigateTo(R.id.action_registerFragment2_to_homeFragment)
        pref.save(true, Constants.IS_LOGIN)
    }



    /**
     * clear error message when user try to
     * enter invalid data
     */
    private fun clearErrorMessage() {
          binding.layoutName.editText?.doAfterTextChanged {
            binding.layoutName.error = null

          }
         binding.layoutRegisterEmail.editText?.doAfterTextChanged {

                binding.layoutRegisterEmail.error=null
            }
        binding.layoutRegisterPass.editText?.doAfterTextChanged {
            binding.layoutRegisterPass.error=null
        }
    }

    private fun setUpViewAnimation() {
        binding.welcomeText.translationXRightAnimation(200)
        binding.imgRegister.translationXAnimation(200)
        binding.layoutName.translationXAnimation(200)
        binding.layoutRegisterEmail.translationXAnimation(350)
        binding.layoutRegisterPass.translationXAnimation(550)
        binding.btnRegister.translationXAnimation(700)
        binding.tvHaveAccount.translationXAnimation(750)
        binding.tvLogin.translationXAnimation(850)

    }

}