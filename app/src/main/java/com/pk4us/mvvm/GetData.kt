package com.pk4us.mvvm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class GetData:LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getData(){
        println("get data")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun sendData(){
        println("send data")
    }
}