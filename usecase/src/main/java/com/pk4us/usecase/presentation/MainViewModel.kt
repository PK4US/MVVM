package com.pk4us.usecase.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pk4us.usecase.domain.models.SaveUserNameParam
import com.pk4us.usecase.domain.models.UserName
import com.pk4us.usecase.domain.usecase.GetUserNameUseCase
import com.pk4us.usecase.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val mutableResultLiveData = MutableLiveData<String>()
    val resultLiveData:LiveData<String> = mutableResultLiveData

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        mutableResultLiveData.value = resultData.toString()
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        mutableResultLiveData.value = "${userName.firstName} ${userName.lastName}"
    }
}