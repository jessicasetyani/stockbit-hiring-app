package com.stockbit.hiring.feature.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.ActivityLoginBinding
import com.stockbit.hiring.feature.login.viewModel.LoginViewModel
import com.stockbit.hiring.feature.main.MainActivity
import com.stockbit.hiring.feature.watchlistSymbol.viewModel.WatchlistSymbolViewModel

/**
 * Created by Jessica Setyani on 19/02/22.
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = loginViewModel
        binding.buttonPrimary.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}