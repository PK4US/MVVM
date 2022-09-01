package com.pk4us.usecase.domain.repository

import com.pk4us.usecase.domain.models.SaveUserNameParam
import com.pk4us.usecase.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam):Boolean

    fun getName(): UserName
}