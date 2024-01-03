package com.example.aymarswi.ClaseNumeros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseAnimales.FragmentAnimales8
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNumeros4 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_numeros4, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val llPhisqa = rootView.findViewById<LinearLayout>(R.id.llPhisqa)
        val llSuqta = rootView.findViewById<LinearLayout>(R.id.llSuqta)
        val llPacalqu = rootView.findViewById<LinearLayout>(R.id.llPacalqu)
        val llPusi = rootView.findViewById<LinearLayout>(R.id.llPusi)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        llPhisqa.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNumeros5(),
                args
            )
        }
        llSuqta.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNumeros5(),
                args
            )
        }
        llPacalqu.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNumeros5(),
                args
            )
        }
        llPusi.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNumeros5(),
                args
            )
        }
        return rootView
    }
}