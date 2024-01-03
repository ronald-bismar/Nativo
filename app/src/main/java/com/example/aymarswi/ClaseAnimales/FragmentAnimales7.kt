package com.example.aymarswi.ClaseAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseColores.FragmentColores3
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales7 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_animales7, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnMallku = rootView.findViewById<LinearLayout>(R.id.btnMallku)
        val btnJuku = rootView.findViewById<LinearLayout>(R.id.btnJuku)
        val btnLuli = rootView.findViewById<LinearLayout>(R.id.btnLuli)
        val btnPuma = rootView.findViewById<LinearLayout>(R.id.btnPuma)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnMallku.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales8(),
                args
            )
        }
        btnJuku.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales8(),
                args
            )
        }
        btnLuli.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales8(),
                args
            )
        }
        btnPuma.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales8(),
                args
            )
        }
        return rootView
    }
}