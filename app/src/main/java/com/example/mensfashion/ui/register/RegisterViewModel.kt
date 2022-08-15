package com.example.mensfashion.ui.register

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mensfashion.R
import com.example.mensfashion.utils.ResponseResult
import com.example.mensfashion.utils.User
import com.example.mensfashion.utils.isEmail
import com.example.mensfashion.utils.isPassword

class RegisterViewModel( application: Application) : AndroidViewModel(application) {
    val userName = ObservableField("")
    val userEmail = ObservableField("")
    val userPassword = MutableLiveData("")
     var userNameError =MutableLiveData("")
    val userEmailError=ObservableField <String>()
     val  userPasswordError=MutableLiveData<String>()
    val setLoading=ObservableField(false)

    private val _responseResult: MutableLiveData<User> = MutableLiveData()
    val registerResponseResult: LiveData<User> get() = _responseResult
    fun register() {
        setLoading.set(true)
        val name = userName.get()?.trim() ?: ""
        val password = userPassword.value?.trim() ?: ""
        val email = userEmail.get()?.trim() ?: ""

        when {

            name.isEmpty() -> {
                setLoading.set(false)
                userNameError.value= getApplication<Application>().getString(R.string.required)

            }
            email.isEmpty() -> {
                setLoading.set(false)
                userEmailError.set(getApplication<Application>().getString(R.string.required))

            }
            password.isEmpty() -> {
                setLoading.set(false)
                userPasswordError.value=getApplication<Application>().getString(R.string.required)
            }

            !email.isEmail()-> {
                setLoading.set(false)
                userEmailError.set(getApplication<Application>().getString(R.string.invalid_email))
            }
            !password.isPassword()-> {
                setLoading.set(false)
                userPasswordError.value=getApplication<Application>().getString(R.string.invalid_passsword)
            }
            else -> {
//                 result from repo
//                val result=
//                when(result){
//                  is ResponseResult.Success<*> ->{
                          setLoading.set(false)
  //              _responseResult.postValue(result.data?.user)
//                  }
//                  is ResponseResult.Error<*> ->  {
                      setLoading.set(false)

//                    handle failed
//
//                }

            }
        }

    }





}