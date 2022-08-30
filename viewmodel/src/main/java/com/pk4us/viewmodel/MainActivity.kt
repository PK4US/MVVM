package com.pk4us.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pk4us.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel = ViewModelProvider(this,MainFactory(application,"Factory"))[MainViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        mViewModel.liveData.observe(this, Observer {
            binding.textView.text = it
        })
    }
}