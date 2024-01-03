package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentFamilia5Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_familia5_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Fragment2", "Puntaje recibido: $puntaje")
        val btnY = rootView.findViewById<Button>(R.id.btnY)
        val btnAllchi = rootView.findViewById<Button>(R.id.btnAlch)
        val btnTull = rootView.findViewById<Button>(R.id.btnTull)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnY.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentFamilia6Q(), args)
        }
        btnAllchi.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentFamilia6Q(),
                args
            )
        }
        btnTull.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentFamilia6Q(), args)
        }
        return rootView
    }
}