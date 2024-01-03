package com.example.aymarswi.QuechuaSaludos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludo1Q : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_saludo1_q, container, false)
        val btnMama = rootView.findViewById<ImageButton>(R.id.btnmam)
        val btnhermanom = rootView.findViewById<ImageButton>(R.id.btnhermanom)
        val btnhermanom2 = rootView.findViewById<ImageButton>(R.id.btnhermanom2)
        val btnhermanom3 = rootView.findViewById<ImageButton>(R.id.btnhermanom3)
        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnMama.setOnClickListener {
            args.putInt("valorp", ++puntaje)

            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo2Q(),
                args
            )
        }
        btnhermanom.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo2Q(),
                args
            )
        }
        btnhermanom2.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo2Q(),
                args
            )
        }
        btnhermanom3.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo2Q(),
                args
            )
        }
        return rootView
    }
}