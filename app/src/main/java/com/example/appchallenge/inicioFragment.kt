package com.example.appchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appchallenge.databinding.FragmentInicioBinding


class inicioFragment : Fragment() {
    lateinit var binding: FragmentInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.BUTTONACCEDER.setOnClickListener {

            val usuario = binding.STRINGNAME.text.toString()
            val action = inicioFragmentDirections.actionInicioFragmentToCaptureFragment(usuario)
            findNavController().navigate(action)
        }
    }

}