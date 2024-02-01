package com.example.aymarswi.ClaseNumeros

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNumeros9 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_numeros9, container, false)
        val btnPhisqa3 = rootView.findViewById<Button>(R.id.btnPhisqa3)
        val btnQimsa = rootView.findViewById<Button>(R.id.btnQimsa)
        val btnSuqta4 = rootView.findViewById<Button>(R.id.btnSuqta4)
        val btnMaya = rootView.findViewById<Button>(R.id.btnMaya)
        val imgVSonido = rootView.findViewById<ImageView>(R.id.imgVSonido)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", contador)
        imgVSonido.setOnClickListener {
            val audio = MediaPlayer.create(requireContext(), R.raw.vozphisqa)
            audio.start()
        }
        btnPhisqa3.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,FragmentNumeros10(), args)
        }
        btnQimsa.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,FragmentNumeros10(), args)
        }
        btnSuqta4.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,FragmentNumeros10(), args)
        }
        btnMaya.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,FragmentNumeros10(), args)
        }

        return rootView
    }
}