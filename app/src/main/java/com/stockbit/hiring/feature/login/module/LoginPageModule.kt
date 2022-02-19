package com.stockbit.hiring.di

import com.stockbit.hiring.feature.login.viewModel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Jessica Setyani on 19/02/22.
 */
val loginPageModule = module {
    viewModel { LoginViewModel() }
}