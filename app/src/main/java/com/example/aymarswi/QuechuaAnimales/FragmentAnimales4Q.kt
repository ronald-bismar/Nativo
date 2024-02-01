package com.example.aymarswi.QuechuaAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales4Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_animales4_q, container, false)
        val llPerrito = rootView.findViewById<LinearLayout>(R.id.llPerrito)
        val llGatito = rootView.findViewById<LinearLayout>(R.id.llGatito)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        llPerrito.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentAnimales5Q(),
                args
            )
        }
        llGatito.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentAnimales5Q(),
                args
            )
        }
        return rootView    }
}