package com.example.aymarswi.QuechuaSaludos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Saludos.FragmentSaludos7
import com.example.aymarswi.Util.Utils

class FragmentSaludo6Q : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_saludo6_q, container, false)
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
                R.id.fragmentContainerView3,
                FragmentSaludo7Q(),
                args
            )
        }
        btnsaludos.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo7Q(),
                args
            )
        }
        btnhermano1.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo7Q(),
                args
            )
        }
        return rootView
    }
}