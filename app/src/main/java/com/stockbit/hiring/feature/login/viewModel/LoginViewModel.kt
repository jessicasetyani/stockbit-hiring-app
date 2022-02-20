package com.stockbit.hiring.feature.login.viewModel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.stockbit.common.base.BaseViewModel

/**
 * Created by Jessica Setyani on 19/02/22.
 */
class LoginViewModel : BaseViewModel() {

    @Bindable
    val buttonPrimaryText = MutableLiveData<String>()

    init {
        buttonPrimaryText.value = "Login"
    }

    fun onPrimaryButtonCLicked() {

    }
}