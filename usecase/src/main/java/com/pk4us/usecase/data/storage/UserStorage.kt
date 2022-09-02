package com.pk4us.usecase.data.storage

import com.pk4us.usecase.data.storage.models.User

interface UserStorage {
    fun save(user: User):Boolean

    fun get(): User

}