package com.pk4us.usecase.data.repository

import android.content.Context
import com.pk4us.usecase.domain.models.SaveUserNameParam
import com.pk4us.usecase.domain.models.UserName
import com.pk4us.usecase.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class UserRepositoryImplementation(context:Context):UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME,saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"")?:"Default first name"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME,"")?:"Default last name"

        return UserName(firstName = firstName,lastName = lastName)
    }

}