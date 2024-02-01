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

class FragmentColores4 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores4, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnArumi = rootView.findViewById<Button>(R.id.btnArumi)
        val btnChiqi = rootView.findViewById<Button>(R.id.btnChiqi)
        val btnChumpi = rootView.findViewById<Button>(R.id.btnChumpi)
        val btnChiyara = rootView.findViewById<Button>(R.id.btnChiyara)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnArumi.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores5(),
                args
            )
        }
        btnChiqi.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores5(),
                args
            )
        }
        btnChumpi.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores5(),
                args
            )
        }
        btnChiyara.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentColores5(),
                args
            )
        }
        return rootView
    }
}