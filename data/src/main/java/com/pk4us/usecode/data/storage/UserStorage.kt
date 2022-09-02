package com.pk4us.usecode.data.storage

import com.pk4us.usecode.data.storage.models.User

interface UserStorage {
    fun save(user: User):Boolean

    fun get(): User

}