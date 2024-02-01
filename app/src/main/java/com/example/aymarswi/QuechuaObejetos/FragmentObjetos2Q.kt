package com.example.aymarswi.QuechuaObejetos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentObjetos2Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_objetos2_q, container, false)
        val btn1 = rootView.findViewById<ImageButton>(R.id.imgbtnPapel)
        val btn2 = rootView.findViewById<ImageButton>(R.id.imgbtnLapiz)
        val btn3 = rootView.findViewById<ImageButton>(R.id.imgbtnLibro)
        val btn4 = rootView.findViewById<ImageButton>(R.id.imgbtnGoma)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()

        Log.d("Puntaje", "Puntaje recibido es: $puntaje")
        Log.d("Puntaje", "Contador recibido es: $contador")
        args.putInt("valorc", ++contador)
        btn3.setOnClickListener {
            args.putInt("valorp", ++puntaje)

            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentObjetos3Q(),
                args
            )
        }
        btn2.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentObjetos3Q(),
                args
            )
        }
        btn1.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentObjetos3Q(),
                args
            )
        }
        btn4.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentObjetos3Q(),
                args
            )
        }
        return rootView
    }
}