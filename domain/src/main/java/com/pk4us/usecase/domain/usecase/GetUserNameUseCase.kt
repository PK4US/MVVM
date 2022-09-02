package com.pk4us.usecase.domain.usecase

import com.pk4us.usecase.domain.models.UserName
import com.pk4us.usecase.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}