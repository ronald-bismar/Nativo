package com.example.aymarswi.ClaseNumeros

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNumeros7 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rooView: View = inflater.inflate(R.layout.fragment_numeros7, container, false)
        val ay = rooView.findViewById<EditText>(R.id.ay)
        val ay2 = rooView.findViewById<EditText>(R.id.ay2)
        val ms = rooView.findViewById<EditText>(R.id.ms)
        val us = rooView.findViewById<EditText>(R.id.us)
        val isq = rooView.findViewById<EditText>(R.id.isq)
        val suq = rooView.findViewById<EditText>(R.id.suq)
        val btnComprobar = rooView.findViewById<Button>(R.id.btnComprobar12)

        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnComprobar.setOnClickListener {
            if (ay.text.toString().trim().lowercase() == "ay" && ay2.text.toString().trim()
                    .lowercase() == "ay" && ms.text.toString().trim()
                    .lowercase() == "ms" && us.text.toString().trim()
                    .lowercase() == "us" && isq.text.toString().trim()
                    .lowercase() == "isq" && suq.text.toString().trim().lowercase() == "uq"
            ) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentNumeros8(),
                    args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentNumeros8(),
                    args
                )
            }
        }


        return rooView
    }
}