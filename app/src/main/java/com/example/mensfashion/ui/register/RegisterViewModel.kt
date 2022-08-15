package com.example.mensfashion.ui.register

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mensfashion.R
import com.example.mensfashion.utils.isEmail
import com.example.mensfashion.utils.isPassword

class RegisterViewModel( application: Application) : AndroidViewModel(application) {
    // which better observe or live data in binding
    val userName = ObservableField("")
    val userEmail = ObservableField("")
    val userPassword = MutableLiveData("")
     var userNameError =MutableLiveData("")
    val userEmailError=ObservableField <String>()
     val  userPasswordError=MutableLiveData<String>()

//    private val _response: MutableLiveData<RegisterResult> = MutableLiveData()
//    val registerResponse: LiveData<RegisterResult> get() = _response
    fun register() {
        val name = userName.get()?.trim() ?: ""
        val password = userPassword.value?.trim() ?: ""
        val email = userEmail.get()?.trim() ?: ""

        when {

            name.isEmpty() -> {
                userNameError.value= getApplication<Application>().getString(R.string.required)

            }
            email.isEmpty() -> {
                 userEmailError.set(getApplication<Application>().getString(R.string.required))

            }
            password.isEmpty() -> {
                userPasswordError.value=getApplication<Application>().getString(R.string.required)
            }

            !email.isEmail()-> {
                userEmailError.set(getApplication<Application>().getString(R.string.invalid_email))
            }
            !password.isPassword()-> {
                userPasswordError.value=getApplication<Application>().getString(R.string.invalid_passsword)
            }
            else -> {
                // check exist  or not and add new user in repo
//                _response.postValue()
            }


        }

    }





}