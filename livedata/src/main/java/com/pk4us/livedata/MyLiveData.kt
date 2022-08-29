package com.pk4us.livedata

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.OnLifecycleEvent

class MyLiveData:LiveData<String>() {

    fun setValueLiveData(string:String){
        value = string
    }

    override fun onActive() {
        super.onActive()
        //connect to DataBase
        Log.d("MyLog","onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("MyLog","onInactive")
    }
}