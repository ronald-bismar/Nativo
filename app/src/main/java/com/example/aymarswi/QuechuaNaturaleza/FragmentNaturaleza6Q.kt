package com.example.aymarswi.QuechuaNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza7
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentNaturaleza6Q : Fragment() {
    val numeroFragment = 6
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza6_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val btnPanq = rootView.findViewById<Button>(R.id.btnPanq)
        val btnJawira = rootView.findViewById<Button>(R.id.btnJawira)
        val args = Bundle()
        args.putInt("valorc", ++contador)

        btnPanq.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza7Q(),
                args
            )
        }
        btnJawira.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza7Q(),
                args
            )
        }
        return rootView      }
}