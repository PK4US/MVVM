package com.pk4us.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import com.pk4us.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var getData = GetData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycle.addObserver(getData)

        if (lifecycle.currentState == Lifecycle.State.INITIALIZED){
            Log.d("MyLog","INITIALIZED")
        }

        if (lifecycle.currentState == Lifecycle.State.CREATED){
            Log.d("MyLog","CREATED")
        }

        if (lifecycle.currentState == Lifecycle.State.STARTED){
            Log.d("MyLog","STARTED")
        }
    }

    override fun onResume() {
        super.onResume()
        if (lifecycle.currentState == Lifecycle.State.STARTED){
            Log.d("MyLog","STARTED")
        }
    }

}