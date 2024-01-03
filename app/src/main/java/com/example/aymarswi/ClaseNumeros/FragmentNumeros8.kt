package com.example.aymarswi.ClaseNumeros

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseColores.FragmentColores4
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNumeros8 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_numeros8, container, false)
        val btnPaya3 = rootView.findViewById<Button>(R.id.btnPaya3)
        val btnPusi3 = rootView.findViewById<Button>(R.id.btnPusi3)
        val btnSuqta3 = rootView.findViewById<Button>(R.id.btnSuqta3)
        val btnKimsa3 = rootView.findViewById<Button>(R.id.btnKimsa3)
        val btnComprobar13 = rootView.findViewById<Button>(R.id.btnComprobar13)
        val txtCompletarPalabra = rootView.findViewById<TextView>(R.id.txtCompletar)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", contador)

        Utils().formarOracionConTextoDelBotonPara4Botones(
            btnPaya3,
            btnPusi3,
            btnSuqta3,
            btnKimsa3,
            txtCompletarPalabra,
            btnComprobar13,1
        )
        btnComprobar13.setOnClickListener{
            val cad = Utils().obtenerOracionFormada(txtCompletarPalabra)
            Log.d("Oracion","OracionDevuelta: $cad")
            if (cad.trim().lowercase() == "pusi") {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentNumeros9(),
                    args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentNumeros9(),
                    args,
                )
            }
        }
        return rootView
    }
}