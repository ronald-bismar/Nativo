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
import com.example.aymarswi.Saludos.FragmentSaludos8
import com.example.aymarswi.Util.Utils

class FragmentSaludo7Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_saludo7_q, container, false)
        val btnHasta = rootView.findViewById<Button>(R.id.btnHasta)
        val btnCaminar = rootView.findViewById<Button>(R.id.btnCaminar)
        val btnEstoyBien = rootView.findViewById<Button>(R.id.btnEstoyBien)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)

        btnHasta.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo8Q(),
                args
            )
        }

        btnCaminar.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo8Q(),
                args
            )
        }

        btnEstoyBien.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo8Q(),
                args
            )
        }
        return rootView   }
}