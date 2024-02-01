package com.example.aymarswi.Objetos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentObjetos9 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_objetos9, container, false)
        val btnCebada = rootView.findViewById<Button>(R.id.btnCebada)
        val btnPapa1 = rootView.findViewById<Button>(R.id.btnPapa1)
        val btnPapa2 = rootView.findViewById<Button>(R.id.btnCebada2)
        val btnPapa3 = rootView.findViewById<Button>(R.id.btnPapa2)
        val etPapa = rootView.findViewById<TextView>(R.id.etPapa)
        val btnComp = rootView.findViewById<Button>(R.id.btnComp3)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()

        Log.d("Puntaje", "Puntaje recibido es: $puntaje")
        Log.d("Puntaje", "Contador recibido es: $contador")
        args.putInt("valorc", ++contador)

        btnCebada.setOnClickListener {
            etPapa.text = btnCebada.text.toString()
        }
        btnPapa1.setOnClickListener {
            etPapa.text = btnPapa1.text.toString()
        }
        btnPapa2.setOnClickListener {
            etPapa.text = btnPapa2.text.toString()
        }
        btnPapa3.setOnClickListener {
            etPapa.text = btnPapa3.text.toString()
        }
        btnComp.setOnClickListener {
            if (etPapa.text.toString() == btnPapa3.text.toString()) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireContext() as AppCompatActivity, R.id.contenedorDeFragments,
                    FragmentObjetos10(), args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity, R.id.contenedorDeFragments,
                    FragmentObjetos10(), args
                )
            }
        }
        return rootView
    }
}