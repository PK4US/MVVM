package com.pk4us.usecase.data.repository

import com.pk4us.usecase.data.storage.models.User
import com.pk4us.usecase.data.storage.UserStorage
import com.pk4us.usecase.domain.models.SaveUserNameParam
import com.pk4us.usecase.domain.models.UserName
import com.pk4us.usecase.domain.repository.UserRepository

class UserRepositoryImplementation(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveParam.name, lastName = "")

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}