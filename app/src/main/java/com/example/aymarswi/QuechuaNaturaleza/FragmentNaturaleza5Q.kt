package com.example.aymarswi.QuechuaNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza6
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentNaturaleza5Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza5_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val btnSembrar = rootView.findViewById<Button>(R.id.btnSembrar);
        val btnRegarPlanta = rootView.findViewById<Button>(R.id.btnRegarPlanta)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnSembrar.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza6Q(),
                args
            )
        }
        btnRegarPlanta.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza6Q(),
                args
            )
        }
        return rootView
    }
}