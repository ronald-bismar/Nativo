package com.example.aymarswi.ClaseAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseVerbos.FragmentVerbos2
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales8 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_animales8, container, false)
        val btnKhayax = rootView.findViewById<Button>(R.id.btnKhayax)
        val btnAnux = rootView.findViewById<Button>(R.id.btnAnux)
        val btnSuriTijus = rootView.findViewById<Button>(R.id.btnSuriTijus)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnKhayax.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales9(),
                args
            )
        }
        btnAnux.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales9(),
                args
            )
        }
        btnSuriTijus.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentAnimales9(),
                args
            )
        }
        return rootView
    }
}