package com.example.aymarswi.ClaseVerbos

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


class FragmentVerbos5 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_verbos5, container, false)
        val btnUñchukiyaña = rootView.findViewById<Button>(R.id.btnUñchukiyaña)
        val btnLuraña = rootView.findViewById<Button>(R.id.btnLuraña)
        val btnQillqaña = rootView.findViewById<Button>(R.id.btnQillqaña)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnUñchukiyaña.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos6(),
                args
            )
        }
        btnLuraña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos6(),
                args
            )
        }
        btnQillqaña.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos6(),
                args
            )
        }
        return rootView
    }
}