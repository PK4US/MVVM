package com.pk4us.usecase.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pk4us.usecase.domain.usecase.GetUserNameUseCase
import com.pk4us.usecase.domain.usecase.SaveUserNameUseCase
import com.pk4us.usecode.data.repository.UserRepositoryImplementation
import com.pk4us.usecode.data.storage.sharedprefs.SharedPrefUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userRepository by lazy {
        UserRepositoryImplementation(
            userStorage = SharedPrefUserStorage(
                context = context
            )
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}