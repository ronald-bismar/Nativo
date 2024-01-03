package com.example.aymarswi.QuechuaVerbos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseVerbos.FragmentVerbos8
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos7Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_verbos7_q, container, false)
        val btnCocinar = rootView.findViewById<Button>(R.id.btnCocinar)
        val btnLavar = rootView.findViewById<Button>(R.id.btnLavar)
        val btnJugar = rootView.findViewById<Button>(R.id.btnJugar)
        //Acceder a los valores enviados desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnCocinar.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerbos8Q(),
                args
            )
        }
        btnLavar.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerbos8Q(),
                args
            )
        }
        btnJugar.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerbos8Q(),
                args
            )
        }
        return rootView
    }
}