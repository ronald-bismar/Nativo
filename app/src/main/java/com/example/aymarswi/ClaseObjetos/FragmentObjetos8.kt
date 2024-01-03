package com.example.aymarswi.Objetos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.QuechuaObejetos.FragmentObjetos9Q
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentObjetos8 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_objetos8, container, false)
        val btn1 = rootView.findViewById<ImageButton>(R.id.imageButton7)
        val btn2 = rootView.findViewById<ImageButton>(R.id.imageButton6)
        val btn3 = rootView.findViewById<ImageButton>(R.id.imageButton4)
        val btn4 = rootView.findViewById<ImageButton>(R.id.imageButton5)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        Log.d("Puntaje", "Puntaje recibido es: $puntaje")
        Log.d("Puntaje", "Contador recibido es: $contador")
        args.putInt("valorc", ++contador)
        btn1.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentObjetos9(),
                args
            )
        }
        btn2.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentObjetos9(),
                args
            )
        }
        btn3.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentObjetos9(),
                args
            )
        }
        btn4.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentObjetos9Q(),
                args
            )
        }
        return rootView
    }
}