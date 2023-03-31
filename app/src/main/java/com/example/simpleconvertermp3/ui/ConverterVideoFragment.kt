package com.example.simpleconvertermp3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.simpleconvertermp3.databinding.FragmentConverterVideoBinding
import com.example.simpleconvertermp3.helpers.Fields

class ConverterVideoFragment : Fragment() {
    private lateinit var binding: FragmentConverterVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentConverterVideoBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    private fun initViews() {
        convertVideoMp3()
        animationMarquee()
    }

    private fun convertVideoMp3() {
        binding.buttonConvertMp3.setOnClickListener {
            if (verifications()) {
                Toast.makeText(context, "Funcionou garai!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verifications(): Boolean {
        binding.apply {
            if (Fields().emptyField(editTextUrlConvert, requireContext()) &&
                Fields().isYoutubeUrl(editTextUrlConvert, requireContext())
            ) {
                return true
            }
            return false
        }
    }

    private fun animationMarquee() {
        binding.textViewAnimationMarquee.isSelected = true
    }
}