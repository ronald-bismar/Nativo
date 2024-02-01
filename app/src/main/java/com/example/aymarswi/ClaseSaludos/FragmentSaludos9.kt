package com.example.aymarswi.Saludos

import android.media.MediaPlayer
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

class FragmentSaludos9 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_saludos9, container, false)
        val btnBuenDia = rootView.findViewById<Button>(R.id.btnBuenDia)
        val btnBien = rootView.findViewById<Button>(R.id.btnBien)
        val btnMal = rootView.findViewById<Button>(R.id.btnMal)
        val btnCEstas = rootView.findViewById<Button>(R.id.btnCEstas)
        val imgVSonido = rootView.findViewById<TextView>(R.id.txtWaliki)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val args = Bundle()
        args.putInt("valorc", contador)
        imgVSonido.setOnClickListener {
            val audio = MediaPlayer.create(requireContext(), R.raw.vozphisqa)
            audio.start()
        }
        btnBuenDia.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentSaludos10(), args
            )
        }
        btnBien.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentSaludos10(), args
            )
        }
        btnMal.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentSaludos10(), args
            )
        }
        btnCEstas.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentSaludos10(), args
            )
        }

        return rootView
    }
}