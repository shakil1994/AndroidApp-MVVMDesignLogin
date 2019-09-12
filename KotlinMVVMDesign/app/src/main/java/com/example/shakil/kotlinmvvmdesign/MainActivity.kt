package com.example.shakil.kotlinmvvmdesign

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shakil.kotlinmvvmdesign.Interface.LoginResultCallbacks
import com.example.shakil.kotlinmvvmdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoginResultCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this,
            LoginViewModelFactory(this)).get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
