package com.pk4us.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Transformation
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.pk4us.livedata.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var liveDataValue = MutableLiveData<String>()
    private var liveDataPostValue = MutableLiveData<String>()

    private var myLiveData3 = MyLiveData()
    private var myLiveData4 = MyLiveData()
    private lateinit var observer: Observer<String>

    private var liveDataString = MutableLiveData<String>()
    private var liveDataInt = MutableLiveData<Int>()

    private var ldString = MutableLiveData<String>()
    private var ldString2 = MutableLiveData<String>()
    private val mediatorLiveData = MediatorLiveData<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//________________________________________________________________________________________________________
        liveDataValue.value = "value из главного потока"
        binding.testText1.text = liveDataValue.value

        CoroutineScope(Dispatchers.IO).launch { liveDataPostValue.postValue("postvalue из другого потока") }
        binding.testText2.text = liveDataPostValue.value
//________________________________________________________________________________________________________
        myLiveData3.observe(this, Observer {
            binding.testText3.text = it
        })
        binding.buttonSave3.setOnClickListener {
            myLiveData3.setValueLiveData(binding.editTex3.text.toString())
        }
//________________________________________________________________________________________________________
        observer = Observer { binding.testText4.text = it }
        binding.buttonSave4.setOnClickListener {
            myLiveData4.setValueLiveData(binding.editText4.text.toString())
        }
//________________________________________________________________________________________________________
        liveDataString.value = "liveDataString"
        liveDataInt.value = 1

        binding.testText6.text = liveDataString.value + " string"
        binding.testText7.text = liveDataInt.value.toString() + " int"

        binding.button67.setOnClickListener {
            liveDataString = Transformations.map(liveDataInt) {
                it.toString()
            } as MutableLiveData<String>

            liveDataString.observe(this) {
                binding.testText6.text = it
            }
        }
//________________________________________________________________________________________________________

        ldString.value = "ldString"
        ldString2.value = "ldString2"

        mediatorLiveData.addSource(ldString) {
            binding.testText8.text = it
        }
        mediatorLiveData.addSource(ldString2){
            binding.testText9.text = it
        }

        mediatorLiveData.observe(this, Observer {

        })

        binding.button8.setOnClickListener {
            ldString.value = binding.editText8.text.toString()
        }

        binding.button9.setOnClickListener {
            ldString2.value = binding.editText9.text.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        myLiveData4.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        myLiveData4.removeObserver(observer)
    }
}