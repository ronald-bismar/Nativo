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


class FragmentFamilia9Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView: View = inflater.inflate(R.layout.fragment_familia9_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnAlchhi = rootView.findViewById<Button>(R.id.btnAlchhi)
        val btnJila = rootView.findViewById<Button>(R.id.btnJila)
        val btnKullaka3 = rootView.findViewById<Button>(R.id.btnKullaka3)
        val btnTayka1 = rootView.findViewById<Button>(R.id.btnTayka1)
        val etPalabra2 = rootView.findViewById<TextView>(R.id.etContenPalabra)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar16)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnAlchhi.setOnClickListener {
            etPalabra2.text = btnAlchhi.text.toString()

        }
        btnJila.setOnClickListener {
            etPalabra2.text = btnJila.text.toString()
        }
        btnKullaka3.setOnClickListener {
            etPalabra2.text = btnKullaka3.text.toString()
        }
        btnTayka1.setOnClickListener {
            etPalabra2.text = btnTayka1.text.toString()
        }
        etPalabra2.setOnClickListener {
            etPalabra2.text = ""
        }

        btnComprobar.setOnClickListener {
            if (etPalabra2.text.toString() == btnAlchhi.text.toString()) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentFamilia10Q(),
                    args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentFamilia10Q(),
                    args
                )
            }
        }
        return rootView
    }
}