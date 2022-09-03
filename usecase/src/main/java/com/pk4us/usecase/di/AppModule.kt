package com.pk4us.usecase.di

import com.pk4us.usecase.domain.usecase.GetUserNameUseCase
import com.pk4us.usecase.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>{
        MainViewModel(getUserNameUseCase = get(), saveUserNameUseCase = get())
    }
}