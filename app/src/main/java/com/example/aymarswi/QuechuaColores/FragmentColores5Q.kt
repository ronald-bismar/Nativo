package com.example.aymarswi.QuechuaColores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores5Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores5_q, container, false)
        val btnCeleste = rootView.findViewById<Button>(R.id.btnCeleste)
        val btnCeleste2 = rootView.findViewById<Button>(R.id.btnCeleste2)
        val btnCeleste3 = rootView.findViewById<Button>(R.id.btnCeleste3)
        val btnVerde = rootView.findViewById<Button>(R.id.btnVerde)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnCeleste.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores6Q(),
                args
            )
        }
        btnVerde.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores6Q(),
                args
            )
        }
        btnCeleste2.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores6Q(),
                args
            )
        }
        btnCeleste3.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores6Q(),
                args
            )
        }


        return rootView
    }
}