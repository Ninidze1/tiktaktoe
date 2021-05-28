package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    
    private var option: Int = -1
    
    private lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        
        binding.buttonThree.setOnClickListener { 
            option = 0
        }
        
        binding.buttonFour.setOnClickListener { 
            option = 1
        }
        
        binding.buttonFive.setOnClickListener { 
            option = 2
        }
        
        binding.startButton.setOnClickListener { 
            when (option) {
                0 -> findNavController().navigate(R.id.action_startFragment_to_nineFragment)
                1 -> findNavController().navigate(R.id.action_startFragment_to_fourFragment)
                2 -> findNavController().navigate(R.id.action_startFragment_to_fiveFragment)
                else -> Toast.makeText(context, "Choose option", Toast.LENGTH_SHORT).show()
            }
        }
        
    }

}