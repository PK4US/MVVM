package com.pk4us.usecase.di

import com.pk4us.usecase.domain.repository.UserRepository
import com.pk4us.usecode.data.repository.UserRepositoryImplementation
import com.pk4us.usecode.data.storage.UserStorage
import com.pk4us.usecode.data.storage.sharedprefs.SharedPrefUserStorage
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> { SharedPrefUserStorage(context = get()) }
    single<UserRepository> { UserRepositoryImplementation(userStorage = get()) }
}