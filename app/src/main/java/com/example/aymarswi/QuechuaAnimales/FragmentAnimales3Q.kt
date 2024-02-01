package com.example.aymarswi.QuechuaAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseAnimales.FragmentAnimales4
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales3Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_animales3_q, container, false)
        val btnCondorVuela = rootView.findViewById<Button>(R.id.btnCondorVuela)
        val btnCondorCome = rootView.findViewById<Button>(R.id.btnCondorCome)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnCondorVuela.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentAnimales4Q(),
                args
            )
        }
        btnCondorCome.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentAnimales4(),
                args
            )
        }
        return rootView
    }
}