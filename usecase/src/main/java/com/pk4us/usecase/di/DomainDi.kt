package com.pk4us.usecase.di

import com.pk4us.usecase.domain.usecase.GetUserNameUseCase
import com.pk4us.usecase.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> { GetUserNameUseCase(userRepository = get()) }
    factory<SaveUserNameUseCase> { SaveUserNameUseCase(userRepository = get()) }
}