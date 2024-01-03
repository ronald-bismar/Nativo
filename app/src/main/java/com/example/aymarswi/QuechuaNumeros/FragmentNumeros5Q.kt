package com.example.aymarswi.QuechuaNumeros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseNumeros.FragmentNumeros6
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNumeros5Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_numeros5_q, container, false)
        val btnSuxtaJ = rootView.findViewById<Button>(R.id.btnSuxtaJ)
        val btnKimsaJ = rootView.findViewById<Button>(R.id.btnKimsaJ)


        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnSuxtaJ.setOnClickListener {
            args.putInt("valorp", ++puntaje)

            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNumeros6Q(),
                args
            )
        }
        btnKimsaJ.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNumeros6Q(),
                args
            )
        }
        return rootView    }
}