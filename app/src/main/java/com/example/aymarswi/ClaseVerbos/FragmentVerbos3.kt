package com.example.aymarswi.ClaseVerbos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_verbos3, container, false)
        val btnArsuña = rootView.findViewById<LinearLayout>(R.id.btnArsuña)
        val btnApnaqaña = rootView.findViewById<LinearLayout>(R.id.btnApnaqaña)
        val btnIrnaqaña = rootView.findViewById<LinearLayout>(R.id.btnIrnaqaña)
        val btnIkiña = rootView.findViewById<LinearLayout>(R.id.btnIkiña)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnArsuña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos4(),
                args
            )
        }
        btnApnaqaña.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos4(),
                args
            )
        }
        btnIrnaqaña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos4(),
                args
            )
        }
        btnIkiña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos4(),
                args
            )
        }
        return rootView
    }
}