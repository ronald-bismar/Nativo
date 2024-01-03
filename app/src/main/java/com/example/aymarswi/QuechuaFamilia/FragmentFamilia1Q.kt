package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentFamilia1Q : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_familia1_q, container, false)
        val btnPapa = rootView.findViewById<ImageButton>(R.id.imgBtnPapa)
        val btnHermano = rootView.findViewById<ImageButton>(R.id.imgBtnHermano)
        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnPapa.setOnClickListener {
            args.putInt("valorp", ++puntaje)

            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentFamilia2Q(),
                args
            )
        }
        btnHermano.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentFamilia2Q(),
                args
            )
        }
        return rootView
    }
}