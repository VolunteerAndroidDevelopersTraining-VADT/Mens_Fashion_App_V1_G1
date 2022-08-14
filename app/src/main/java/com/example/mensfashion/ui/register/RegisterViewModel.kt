package com.example.mensfashion.ui.register

import android.content.ContentValues.TAG
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mensfashion.utils.isEmail
import com.example.mensfashion.utils.isPassword

class RegisterViewModel() : ViewModel() {
    // which better observe or live data in binding
    var user_name = ObservableField<String>("")
    var user_email = ObservableField<String>("")
    var user_password = MutableLiveData<String>("")

    private val _response: MutableLiveData<RegisterResult> = MutableLiveData()
    val registerResponse: LiveData<RegisterResult> get() = _response
    fun register() {
        var name = user_name.get()?.trim() ?: ""
        var password = user_password.value?.trim() ?: ""
        var email = user_email.get()?.trim() ?: ""

        when {

            name.isNullOrEmpty() -> {
                _response.postValue(RegisterResult.InvalidResult(RegisterError.EmptyName))
            }
            email.isNullOrEmpty() -> {
                _response.postValue(RegisterResult.InvalidResult(RegisterError.EmptyEmail))

            }
            password.isNullOrEmpty() -> {
                _response.postValue(RegisterResult.InvalidResult(RegisterError.EmptyPassword))

            }

            !isValidEmail(email) -> {
                _response.postValue(RegisterResult.InvalidResult(RegisterError.EmailInvalid))

            }
            !isValidPassword(password) -> {
                _response.postValue(RegisterResult.InvalidResult(RegisterError.PasswordInvalid))
            }
            else -> {
                // check exist  or not and add new user in repo
                _response.postValue(RegisterResult.RegisterSuccessful)
            }


        }

    }

    private fun isValidEmail(email: String): Boolean {
        return when {
            !email.isEmail() -> false
            else -> true
        }
    }

    private fun isValidPassword(password: String): Boolean {
        return when {
            !password.isPassword() -> false
            else -> true
        }
    }


    enum class RegisterError {
        EmptyName,
        EmptyEmail,
        EmailInvalid,
        PasswordInvalid,
        EmptyPassword
    }

    sealed class RegisterResult {
        object RegisterSuccessful : RegisterResult()
        data class InvalidResult(val registerError: RegisterError) : RegisterResult()
        object RegisterFailure : RegisterResult()
    }
}