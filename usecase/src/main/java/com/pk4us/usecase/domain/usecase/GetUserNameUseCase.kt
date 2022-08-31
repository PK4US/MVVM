package com.pk4us.usecase.domain.usecase

import com.pk4us.usecase.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Eugene", lastName = "Stepanchuk")
    }
}