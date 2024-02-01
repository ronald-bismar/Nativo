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

class FragmentColores1Q : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores1_q, container, false)
        val btnBlanco = rootView.findViewById<Button>(R.id.btnBlanco)
        val btnAzul = rootView.findViewById<Button>(R.id.btnAzul)
        val btnAzul1 = rootView.findViewById<Button>(R.id.btnAzul2)
        val btnAzul2 = rootView.findViewById<Button>(R.id.btnAzul3)
        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnBlanco.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores2Q(),
                args
            )
        }
        btnAzul.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores2Q(),
                args
            )
        }
        btnAzul1.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores2Q(),
                args
            )
        }
        btnAzul2.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores2Q(),
                args
            )
        }
        return rootView
    }
}