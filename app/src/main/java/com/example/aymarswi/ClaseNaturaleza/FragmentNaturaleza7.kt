package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseNumeros.FragmentNumeros5
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNaturaleza7 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza7, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val llAli = rootView.findViewById<LinearLayout>(R.id.llAli)
        val llPanqara = rootView.findViewById<LinearLayout>(R.id.llPanqara)
        val llKhunu = rootView.findViewById<LinearLayout>(R.id.llKhunu)
        val llKhunuqullu = rootView.findViewById<LinearLayout>(R.id.llKhunuqullu)
        val args = Bundle()
        args.putInt("valorc", ++contador)

        llPanqara.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza8(),
                args
            )
        }

        llAli.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza8(),
                args
            )
        }
        llKhunu.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza8(),
                args
            )
        }
        llKhunuqullu.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza8(),
                args
            )
        }

        return rootView    }
}