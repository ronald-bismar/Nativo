package com.example.aymarswi.ClaseSaludos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Saludos.FragmentSaludos7
import com.example.aymarswi.Util.Utils

class FragmentSaludos6 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_saludos6, container, false)
        val btnfamilia = rootView.findViewById<Button>(R.id.btnfamilia)
        val btnsaludos = rootView.findViewById<Button>(R.id.btnsaludos)
        val btnhermano1 = rootView.findViewById<Button>(R.id.btnhermano1)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnfamilia.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludos7(),
                args
            )
        }
        btnsaludos.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludos7(),
                args
            )
        }
        btnhermano1.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludos7(),
                args
            )
        }
        return rootView
    }
}