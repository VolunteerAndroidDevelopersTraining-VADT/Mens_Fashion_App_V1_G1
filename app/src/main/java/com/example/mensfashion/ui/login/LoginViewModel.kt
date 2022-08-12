package com.example.mensfashion.ui.login

import android.content.ContentValues.TAG
import android.database.Observable
import android.util.Log
import android.widget.EditText
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mensfashion.utils.isEmail
import com.example.mensfashion.utils.isPassword
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class LoginViewModel:ViewModel() {

    var userEmail=ObservableField<String>("")
    var userPassword=ObservableField<String>("")

    private val _response: MutableLiveData<LoginResult> = MutableLiveData()
    val loginResponse: LiveData<LoginResult> get() = _response



    fun login() {
        var password = userPassword.get()?.trim() ?: ""
        var email = userEmail.get()?.trim() ?: ""

        when {

            email.isNullOrEmpty() -> {
                _response.postValue(LoginResult.InvalidResult(LoginError.EmptyEmail))

            }
            password.isNullOrEmpty() -> {
                _response.postValue(LoginResult.InvalidResult(LoginError.EmptyPassword))

            }

            !isValidEmail(email) -> {
                _response.postValue(LoginResult.InvalidResult(LoginError.EmailError))

            }
            !isValidPassword(password) -> {
                Log.e(TAG, "loginpppppppppppppp: ", )
                _response.postValue(LoginResult.InvalidResult(LoginError.PasswordError))
            }
            else ->{
                // check exist user in repo
                _response.postValue(LoginResult.LoginSuccessful)
            }

        }
    }




    private fun isValidEmail(email:String): Boolean {
        return when {
            !email.isEmail() -> false
            else ->true
        }
    }


    private fun isValidPassword(password:String): Boolean {
        return when {
            !password.isPassword() -> false
            else -> true
        }
    }


    enum class LoginError {
        EmailError,
        PasswordError,
        EmptyEmail,
        EmptyPassword

    }

    sealed class LoginResult {
        object LoginSuccessful : LoginResult()
        data class InvalidResult(val loginError: LoginError) : LoginResult()
        object LoginFailure : LoginResult()
    }

}