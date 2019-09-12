package com.example.shakil.kotlinmvvmdesign.Interface

interface LoginResultCallbacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}