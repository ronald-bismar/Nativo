package com.example.aymarswi.ClaseColores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores7 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores7, container, false)


        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnAzul1 = rootView.findViewById<Button>(R.id.btnAzul1)
        val btnVerde = rootView.findViewById<Button>(R.id.btnVerde)
        val btnNaranja = rootView.findViewById<Button>(R.id.btnNaranja)
        val btnNegro = rootView.findViewById<Button>(R.id.btnNegro)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnAzul1.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores8(),
                args
            )
        }
        btnVerde.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores8(),
                args
            )
        }
        btnNaranja.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores8(),
                args
            )
        }
        btnNegro.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores8(),
                args
            )
        }
        return rootView
    }
}