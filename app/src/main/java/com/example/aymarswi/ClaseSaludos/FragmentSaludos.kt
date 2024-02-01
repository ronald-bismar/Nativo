package com.example.aymarswi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.ClaseSaludos.FragmentSaludos2
import com.example.aymarswi.Util.Utils


class FragmentSaludos : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_saludos, container, false)
        val btnhermanom = rootView.findViewById<ImageButton>(R.id.btnhermanom)
        val btnmam = rootView.findViewById<ImageButton>(R.id.btnmam)
        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnhermanom.setOnClickListener {
            args.putInt("valorp", puntaje)

            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludos2(),
                args
            )
        }
        btnmam.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentSaludos2(),
                args
            )
        }
        return rootView   }
}