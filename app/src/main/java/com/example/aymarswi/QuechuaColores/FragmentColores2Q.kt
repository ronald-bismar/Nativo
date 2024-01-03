package com.example.aymarswi.QuechuaColores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseColores.FragmentColores3
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores2Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores2_q, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnQillu = rootView.findViewById<Button>(R.id.btnQillu)
        val btnLarama = rootView.findViewById<Button>(R.id.btnLarama)
        val btnChuqña = rootView.findViewById<Button>(R.id.btnChuqña)
        val btnWila = rootView.findViewById<Button>(R.id.btnWila1)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnWila.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3Q(),
                args
            )
        }
        btnQillu.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3Q(),
                args
            )
        }
        btnLarama.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3Q(),
                args
            )
        }
        btnChuqña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3Q(),
                args
            )
        }
        return rootView
    }
}