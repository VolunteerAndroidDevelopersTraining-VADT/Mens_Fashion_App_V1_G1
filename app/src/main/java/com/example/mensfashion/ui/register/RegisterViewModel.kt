package com.example.mensfashion.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mensfashion.utils.isEmail
import com.example.mensfashion.utils.isPassword

class RegisterViewModel() : ViewModel() {
    private var _registerResult: MutableLiveData<String> = MutableLiveData()
    var registerResult: LiveData<String> = _registerResult
    var email: String = "" //if i will use data binding, will use it
    fun registerUser(userName: String, email: String, passward: String) {
        _registerResult.value =  when {
            userName.isEmpty() -> {
                  "required"
            }
            !email.isEmail() -> {
                "invalid Email!"
            }
            //!passward.isPassword() -> {
            passward.isEmpty() -> {
                "invalid passward!"
            }

            else -> ({
                // check user existence, if not exist->successfully, else-> user alrady exist
                "successfully\uD83C\uDF89"
            }).toString()
        }
    }

}