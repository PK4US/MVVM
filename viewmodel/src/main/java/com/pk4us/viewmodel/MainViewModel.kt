package com.pk4us.viewmodel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application,val text:String) : AndroidViewModel(application) {

    val liveData = MutableLiveData<String>()

    init {
        startTimer()
    }

    private fun startTimer(){
        object : CountDownTimer(20000,1000){
            override fun onFinish() {
                Toast.makeText(getApplication(), "Hello", Toast.LENGTH_SHORT).show()
            }
            override fun onTick(t: Long) {
                liveData.value = (t/1000).toString()
            }
        }.start()
    }
}