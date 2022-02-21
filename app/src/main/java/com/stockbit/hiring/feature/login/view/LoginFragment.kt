package com.stockbit.hiring.feature.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.FragmentLoginBinding
import com.stockbit.hiring.feature.login.viewModel.LoginViewModel

/**
 * Created by Jessica Setyani on 20/02/22.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = loginViewModel
        setLoginForm()
        setRegistrationButtonText()
        return binding.root
    }

    private fun setLoginForm() {
        loginViewModel.errorMessage.observe(this.viewLifecycleOwner, {
            if(it.equals("data is valid")) {
                loginViewModel.clearErrorMessage()
                findNavController().navigate(R.id.action_login_to_watchlist)
            } else {
                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setRegistrationButtonText() {
        loginViewModel.setButtonText(
            getString(R.string.login_button_text),
            getString(R.string.login_fingerprint_button_text)
        )
    }


}