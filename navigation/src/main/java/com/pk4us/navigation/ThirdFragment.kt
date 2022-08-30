package com.pk4us.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pk4us.navigation.databinding.FragmentSecondBinding
import com.pk4us.navigation.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        fun newInstance() = ThirdFragment()

    }

    override fun onStart() {
        super.onStart()
        binding.button3.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_thirdFragment_to_secondFragment)
        }
    }
}