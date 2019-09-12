package com.example.shakil.kotlinmvvmdesign

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.shakil.kotlinmvvmdesign.Interface.LoginResultCallbacks
import com.example.shakil.kotlinmvvmdesign.Model.User

class LoginViewModel(private val listener: LoginResultCallbacks): ViewModel() {

    private val user: User
    init {
        this.user = User("", "")
    }

    //Write method to get Email from EditText and set to user
    val emailTextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }

    //Write method to get Password from EditText and set to user
    val passwordTextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            user.setPassword(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    //Write method to process Login
    fun onLoginClicked(view: View) {
        /*if (user.isDataValid){
            listener.onSuccess("Login Success")
        }
        else {
            listener.onError("Login Error")
        }*/

        val errorCode:Int = user.isDataValid()
        if (errorCode == 0) {
            listener.onError("Email must not me null")
        } else if (errorCode == 1) {
            listener.onError("Your email is invalid")
        } else if (errorCode == 2) {
            listener.onError("Password length must greater then 6 characters")
        } else {
            listener.onSuccess("Login Success")
        }
    }

}