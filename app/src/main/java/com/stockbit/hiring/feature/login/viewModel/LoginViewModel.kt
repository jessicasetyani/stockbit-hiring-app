package com.stockbit.hiring.feature.login.viewModel

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import com.stockbit.common.base.BaseViewModel


/**
 * Created by Jessica Setyani on 19/02/22.
 */
class LoginViewModel : BaseViewModel() {
    val errorMessage = MutableLiveData<String>()
    val buttonPrimaryText = MutableLiveData<String>()
    val buttonSecondText = MutableLiveData<String>()
    val username = MutableLiveData<String>()
    val passwordTxt = MutableLiveData<String>()

    init {
        errorMessage.value = ""
    }

    fun setButtonText(primaryButtonText: String, secondaryButtonText: String) {
        buttonPrimaryText.value = primaryButtonText
        buttonSecondText.value = secondaryButtonText
    }

    fun onButtonPrimaryClicked() {
        val isEmptyUsername = username.value?.isBlank()
        val isEmptyPassword = passwordTxt.value?.isBlank()
        errorMessage.value = when {
            isEmptyUsername == true -> "The user field is required"
            isEmptyPassword == true -> "The password field is required"
            isEmptyUsername == true -> "All field is required"
            getValidateEmail() -> "Username or password is incorrect. Please try again"
            else -> "data is valid"
        }
    }

    fun clearErrorMessage() {
        errorMessage.value = ""
    }

    private fun getValidateEmail(): Boolean = buttonPrimaryText.value.toString().isValidEmail()

    private fun String.isValidEmail(): Boolean {
        return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

}