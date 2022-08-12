package com.example.mensfashion.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mensfashion.utils.isEmail

class LoginViewModel() : ViewModel() {
    private val _loginResult: MutableLiveData<String> = MutableLiveData()
    var loginResult: LiveData<String> = _loginResult

    fun userLogin(email: String, passward: String) {
        validateData(email, passward)
    }

    private fun validateData(email: String, passward: String) {
        _loginResult.value = when {
            !email.isEmail() ->"invalid Email!"
            passward.isEmpty() ->"required"
            else -> {
                checkUser(email, passward)
            }
        }.toString()
    }

    private fun checkUser(email: String, passward: String): String {
        return "exist"
    }


}