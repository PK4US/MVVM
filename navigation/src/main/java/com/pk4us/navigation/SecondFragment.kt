package com.pk4us.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pk4us.navigation.databinding.FragmentFirstBinding
import com.pk4us.navigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        fun newInstance() = ThirdFragment()

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(activity as MainActivity, (arguments?.getString("key")), Toast.LENGTH_SHORT).show()

        binding.button21.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_firstFragment)
        }

        binding.button22.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }
}