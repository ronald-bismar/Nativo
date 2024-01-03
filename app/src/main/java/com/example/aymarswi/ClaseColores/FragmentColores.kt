package com.example.aymarswi.ClaseColores

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseVerbos.FragmentVerbos2
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores, container, false)
        val btnBlanco = rootView.findViewById<Button>(R.id.btnBlanco)
        val btnAzul = rootView.findViewById<Button>(R.id.btnAzul)
        var puntaje = 0
        var contador = 1
        val args = Bundle()
        Log.d("Contexto","Contexto ${requireContext()}")
        args.putInt("valorc", ++contador)
        btnBlanco.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores2(),
                args
            )
        }
        btnAzul.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores2(),
                args
            )
        }

        return rootView
    }
}