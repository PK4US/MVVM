package com.pk4us.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pk4us.navigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        fun newInstance() = ThirdFragment()

    }

    override fun onStart() {
        super.onStart()
        binding.button1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key","hello")
            (activity as MainActivity).navController.navigate(R.id.action_firstFragment_to_secondFragment,bundle)
        }
    }
}