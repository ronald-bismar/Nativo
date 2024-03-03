package com.example.aymarswi.Saludos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2v3
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludos8 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_saludos8, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnAudio = rootView.findViewById<ImageButton>(R.id.btnAudio)
        val btnBDTN = rootView.findViewById<ImageButton>(R.id.btnBDTN)
        val btnBDP = rootView.findViewById<ImageButton>(R.id.btnBDP)
        val btnBNMama = rootView.findViewById<ImageButton>(R.id.btnBNMama)
        val btnBTProf = rootView.findViewById<ImageButton>(R.id.btnBTProf)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnBDTN.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentDinamica2v3(),
                args
            )
        }
        btnBDP.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentDinamica2v3(),
                args
            )
        }
        btnBNMama.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentDinamica2v3(),
                args
            )
        }
        btnBTProf.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentDinamica2v3(),
                args
            )
        }
        return rootView
    }
}