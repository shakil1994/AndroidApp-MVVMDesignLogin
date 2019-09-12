package com.example.shakil.kotlinmvvmdesign.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var email:String, private var password: String): BaseObservable() {

    /*val isDataValid: Boolean
    get() = (!TextUtils.isEmpty(getEmail()))
            && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
            && getPassword().length > 6*/

    fun isDataValid():Int{
        if (TextUtils.isEmpty(getEmail())) {
            return 0 //0 code is email empty
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return  1 //1 code is wrong email pattern
        } else if (getPassword().length < 6) {
            return   2 //2 code is password must be grater than 6
        } else {
            return   -1 //-1 code is success
        }
    }

    fun getPassword(): String {
        return password
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String){
        this.email = email
    }

    fun setPassword(password: String){
        this.password = password
    }
}