package com.example.aymarswi.QuechuaNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentNaturaleza1Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza1_q, container, false)
        val btnAli = rootView.findViewById<Button>(R.id.btnAli)
        val btnPanqara = rootView.findViewById<Button>(R.id.btnPanqara)
        val btnPallqa = rootView.findViewById<Button>(R.id.btnPallqa)
        //Iniciar los valores
        var puntaje = 0
        var contador = 1
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")

        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnAli.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentNaturaleza2Q(),
                args
            )
        }
        btnPanqara.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentNaturaleza2Q(),
                args
            )
        }
        /*btnPallqa.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentNaturaleza2(),
                args
            )
        }*/

        return rootView  }
}