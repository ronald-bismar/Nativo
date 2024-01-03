package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentFamilia7Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_familia7_q, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnTayka = rootView.findViewById<Button>(R.id.btnTayka)
        val btnTiwula = rootView.findViewById<Button>(R.id.btnTiwula)
        val btnIpa = rootView.findViewById<Button>(R.id.btnIpa)
        val btnKullaka = rootView.findViewById<Button>(R.id.btnKullaka)
        val etPalabra = rootView.findViewById<TextView>(R.id.etPalabra)
        val btnComprobar = rootView.findViewById<Button>(R.id.appCompatButton8)
        var cont = 0
        val args = Bundle()
        args.putInt("valorc", ++contador)

        btnTayka.setOnClickListener {
            etPalabra.text = btnTayka.text.toString()

        }
        btnTiwula.setOnClickListener {
            etPalabra.text = btnTiwula.text.toString()
        }
        btnIpa.setOnClickListener {
            etPalabra.text = btnIpa.text.toString()

        }
        btnKullaka.setOnClickListener {
            etPalabra.text = btnKullaka.text.toString()
        }
        etPalabra.setOnClickListener {
            etPalabra.text = ""
        }

        btnComprobar.setOnClickListener {
            if (etPalabra.text.toString() == btnKullaka.text.toString()) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentFamilia8Q(),
                    args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentFamilia8Q(),
                    args
                )
            }
        }
        return rootView
    }
}