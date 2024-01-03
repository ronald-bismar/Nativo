package com.example.aymarswi.ClaseColores

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores2, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnQillu = rootView.findViewById<Button>(R.id.btnQillu)
        val btnLarama = rootView.findViewById<Button>(R.id.btnLarama)
        val btnChuqña = rootView.findViewById<Button>(R.id.btnChuqña)
        val btnWila = rootView.findViewById<Button>(R.id.btnWila1)
        val args = Bundle()
        Log.d("Contexto","Contexto ${requireContext()}")
        args.putInt("valorc", ++contador)
        btnWila.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3(),
                args
            )
        }
        btnQillu.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3(),
                args
            )
        }
        btnLarama.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3(),
                args
            )
        }
        btnChuqña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentColores3(),
                args
            )
        }
        return rootView
    }
}