package com.example.aymarswi.QuechuaSaludos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludo2Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_saludo2_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val uru = rootView.findViewById<Button>(R.id.uru);
        val aroma = rootView.findViewById<Button>(R.id.aroma)
        val aroma2 = rootView.findViewById<Button>(R.id.aroma2)
        val aroma3 = rootView.findViewById<Button>(R.id.aroma3)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        uru.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludo3Q(),
                args
            )
        }
        aroma.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludo3Q(),
                args
            )
        }
        aroma2.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludo3Q(),
                args
            )
        }
        aroma3.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludo3Q(),
                args
            )
        }
        return rootView  }
}