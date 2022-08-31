package com.pk4us.usecase.domain.usecase

import com.pk4us.usecase.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}