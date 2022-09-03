package com.pk4us.usecase.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pk4us.usecase.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.resultLiveData.observe(this) { binding.dataTextView.text = it }
        binding.sendButton.setOnClickListener { vm.save(binding.dataEditText.text.toString()) }
        binding.receiveButton.setOnClickListener { vm.load() }
    }
}