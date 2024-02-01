package com.example.aymarswi.QuechuaVerbos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos1Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_verbos1_q, container, false)
        val btnMirar = rootView.findViewById<Button>(R.id.btnMirar)
        val btnCaminar = rootView.findViewById<Button>(R.id.btnCaminar)
        val btnComer = rootView.findViewById<Button>(R.id.btnComer)
        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnMirar.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos2Q(),
                args
            )
        }
        btnCaminar.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos2Q(),
                args
            )
        }
        btnComer.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos2Q(),
                args
            )
        }
        return rootView
    }
}