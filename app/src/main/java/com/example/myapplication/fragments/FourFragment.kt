package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFourBinding
import com.example.myapplication.databinding.FragmentNineBinding

class FourFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentFourBinding
    private var buttonNumber = -1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private var active = 1
    private var winnerPlayer = 0

    private var moves = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourBinding.inflate(inflater, container, false)
        clickListen()
        return binding.root
    }

    override fun onClick(view: View?) {
        if (view is ImageButton) {
            when (view.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.button10 -> buttonNumber = 10
                R.id.button11 -> buttonNumber = 11
                R.id.button12 -> buttonNumber = 12
                R.id.button13 -> buttonNumber = 13
                R.id.button14 -> buttonNumber = 14
                R.id.button15 -> buttonNumber = 15
                R.id.button16 -> buttonNumber = 16
            }

            if (buttonNumber != 0)
                startGame(view, buttonNumber)
        } else {
            active = 1
        }
    }


    private fun startGame(clicked: ImageButton, buttonNumber: Int) {

        when (active) {
            1 -> {
                clicked.setBackgroundResource(R.drawable.ic_close_black_24dp)
                firstPlayer.add(buttonNumber)
                moves += 1
                active = 2
            }
            2 -> {
                clicked.setBackgroundResource(R.drawable.ic_circle_black_24dp)
                secondPlayer.add(buttonNumber)
                moves += 1
                active = 1
            }
        }

        clicked.isEnabled = false
        checkWin()

    }

    private fun checkWin() {
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3) && firstPlayer.contains(4)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3) && firstPlayer.contains(4)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(5) && firstPlayer.contains(6) && firstPlayer.contains(7) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(5) && secondPlayer.contains(6) && secondPlayer.contains(7) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(9) && firstPlayer.contains(10) && firstPlayer.contains(11) && firstPlayer.contains(12)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(9) && secondPlayer.contains(10) && secondPlayer.contains(11) && secondPlayer.contains(12)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(13) && firstPlayer.contains(14) && firstPlayer.contains(15) && firstPlayer.contains(16)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(13) && secondPlayer.contains(14) && secondPlayer.contains(15) && secondPlayer.contains(16)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9) && firstPlayer.contains(13)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9) && secondPlayer.contains(13)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(6) && firstPlayer.contains(10) && firstPlayer.contains(14)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(6) && secondPlayer.contains(10) && secondPlayer.contains(14)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(7) && firstPlayer.contains(11) && firstPlayer.contains(15)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(7) && secondPlayer.contains(11) && secondPlayer.contains(15)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(8) && firstPlayer.contains(12) && firstPlayer.contains(16)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(8) && secondPlayer.contains(12) && secondPlayer.contains(16)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(13) && firstPlayer.contains(10) && firstPlayer.contains(7) && firstPlayer.contains(4)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(13) && secondPlayer.contains(10) && secondPlayer.contains(7) && secondPlayer.contains(4)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(6) && firstPlayer.contains(11) && firstPlayer.contains(16)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(6) && secondPlayer.contains(11) && secondPlayer.contains(16)) {
            winnerPlayer = 2
        }

        if (moves == 16 && winnerPlayer == 0) {
            Toast.makeText(requireContext(), "draw!", Toast.LENGTH_LONG).show()

        } else if (moves == 16 && winnerPlayer == 1) {
            Toast.makeText(requireContext(), "X wins!", Toast.LENGTH_LONG).show()

        } else if (moves == 16 && winnerPlayer == 2) {
            Toast.makeText(requireContext(), "O wins!", Toast.LENGTH_LONG).show()
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(requireContext(), "X wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "O wins!", Toast.LENGTH_LONG).show()
            }

            disable()

        }

    }

    private fun clickListen() {
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.button10.setOnClickListener(this)
        binding.button11.setOnClickListener(this)
        binding.button12.setOnClickListener(this)
        binding.button13.setOnClickListener(this)
        binding.button14.setOnClickListener(this)
        binding.button15.setOnClickListener(this)
        binding.button16.setOnClickListener(this)
    }

    private fun disable () {
        binding.button1.isEnabled = false
        binding.button2.isEnabled = false
        binding.button3.isEnabled = false
        binding.button4.isEnabled = false
        binding.button5.isEnabled = false
        binding.button6.isEnabled = false
        binding.button7.isEnabled = false
        binding.button8.isEnabled = false
        binding.button9.isEnabled = false
        binding.button10.isEnabled = false
        binding.button11.isEnabled = false
        binding.button12.isEnabled = false
        binding.button13.isEnabled = false
        binding.button14.isEnabled = false
        binding.button15.isEnabled = false
        binding.button16.isEnabled = false
    }




}