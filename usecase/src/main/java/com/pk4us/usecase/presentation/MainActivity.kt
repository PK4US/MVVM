package com.pk4us.usecase.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pk4us.usecase.data.repository.UserRepositoryImplementation
import com.pk4us.usecase.data.storage.sharedprefs.SharedPrefUserStorage
import com.pk4us.usecase.databinding.ActivityMainBinding
import com.pk4us.usecase.domain.models.SaveUserNameParam
import com.pk4us.usecase.domain.models.UserName
import com.pk4us.usecase.domain.usecase.GetUserNameUseCase
import com.pk4us.usecase.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val userRepository by lazy {UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = applicationContext))}
    private val getUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository)}
    private val saveUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            binding.dataTextView.text = result.toString()

        }

        binding.receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = userName.firstName + " " + userName.lastName
        }
    }
}