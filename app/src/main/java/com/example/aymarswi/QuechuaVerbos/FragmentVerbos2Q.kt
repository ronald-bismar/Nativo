package com.example.aymarswi.QuechuaVerbos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseVerbos.FragmentVerbos3
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos2Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_verbos2_q, container, false)
        val btnPCocina = rootView.findViewById<Button>(R.id.btnPapaCocina)
        val btnPConduce = rootView.findViewById<Button>(R.id.btnPapaConduce)
        val btnPCome = rootView.findViewById<Button>(R.id.abtnPapaCome)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnPCocina.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerbos3Q(),
                args
            )
        }
        btnPCome.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerbos3Q(),
                args
            )
        }
        btnPConduce.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerbos3Q(),
                args
            )
        }

        return rootView
    }
}