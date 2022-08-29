package com.pk4us.lifecycle

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class GetData:LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getData(){
        Log.d("MyLog","getData")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun sendData(){
        Log.d("MyLog","sendData")
    }
}