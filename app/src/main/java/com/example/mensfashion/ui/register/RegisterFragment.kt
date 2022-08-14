package com.example.mensfashion.ui.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.core.onclick
import com.example.mensfashion.core.translationXAnimation
import com.example.mensfashion.core.translationXRightAnimation
import com.example.mensfashion.databinding.FragmentRegisterBinding
import com.example.mensfashion.utils.Constants

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
        showLoading()
        registerViewModel.register()
        registerViewModel.registerResponse.observe(viewLifecycleOwner){ result->
            hiddenLoading()
            when(result){
                is RegisterViewModel.RegisterResult.InvalidResult->{
                    invalidRegisterResult(result)
                }
                RegisterViewModel.RegisterResult.RegisterFailure -> {
                    registerFailed()
                }
                RegisterViewModel.RegisterResult.RegisterSuccessful -> {
                    userRegister()
                }
            }
        }



    }

    /**
     * handle state of failed to register user
     */
    private fun registerFailed() {
        hiddenLoading()

    }

    /**
     * handle   all states of  invalid result
     * when user try to register
     */
    private fun invalidRegisterResult(result: RegisterViewModel.RegisterResult.InvalidResult) {
        hiddenLoading()
        when (result.registerError) {
            RegisterViewModel.RegisterError.EmptyName->{
                binding.layoutName.error=getString(R.string.required)
            }
            RegisterViewModel.RegisterError.EmptyEmail -> {
                binding.layoutRegisterEmail.error=getString(R.string.required)
            }
            RegisterViewModel.RegisterError.EmptyPassword-> {
                binding.layoutRegisterPass.error=getString(R.string.required)
            }
            RegisterViewModel.RegisterError.EmailInvalid->{
                binding.layoutRegisterEmail.error=getString(R.string.invalid_email)
                binding.layoutRegisterEmail.boxStrokeColor=resources.getColor(R.color.red)


            }
            RegisterViewModel.RegisterError.PasswordInvalid->{
                binding.layoutRegisterPass.error=getString(R.string.invalid_passsword)
                binding.layoutRegisterPass.boxStrokeColor=resources.getColor(R.color.red)


            }




            }
        }


    /**
     *  navigate to home when user register
     * save user as login
     */
    private fun userRegister(){
        hiddenLoading()
       navigateTo(R.id.action_registerFragment2_to_homeFragment)
        pref.save(true, Constants.IS_LOGIN)
    }

    private fun showLoading() {
        binding.btnRegister.isEnabled=false
        binding.progressViewStub.viewStub?.visibility=View.VISIBLE

    }
    // dont work ???
    private fun hiddenLoading() {
        binding.btnRegister.isEnabled=true
        binding.progressViewStub.viewStub?.visibility=View.GONE

    }

    /**
     * clear error message when user try to
     * enter invalid data
     */
    private fun clearErrorMessage() {
 binding.layoutName.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                hiddenLoading()
                binding.layoutName.error = null
            }
        })
        binding.layoutRegisterPass.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                hiddenLoading()
                binding.layoutRegisterPass.error = null
            }
        })
        binding.layoutRegisterEmail.editText?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                hiddenLoading()
                binding.layoutRegisterEmail.error=null
            }
        })

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