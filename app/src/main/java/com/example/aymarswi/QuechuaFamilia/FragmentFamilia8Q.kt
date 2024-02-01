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


class FragmentFamilia8Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_familia8_q, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnTiwula3 = rootView.findViewById<Button>(R.id.btnTiwula3)
        val btnKullaka2 = rootView.findViewById<Button>(R.id.btnKullaka2)
        val btnJila1 = rootView.findViewById<Button>(R.id.btnJila1)
        val btnIpa = rootView.findViewById<Button>(R.id.btnIpa)
        val etPalabra = rootView.findViewById<TextView>(R.id.etContenPalabra)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar15)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnTiwula3.setOnClickListener {
            etPalabra.text = btnTiwula3.text.toString()
        }

        btnKullaka2.setOnClickListener {
            etPalabra.text = btnKullaka2.text.toString()
        }
        btnJila1.setOnClickListener {
            etPalabra.text = btnJila1.text.toString()
        }
        btnIpa.setOnClickListener {
            etPalabra.text = btnIpa.text.toString()
        }
        etPalabra.setOnClickListener {
            etPalabra.text = ""
        }

        btnComprobar.setOnClickListener {
            if (etPalabra.text.toString() == btnJila1.text.toString()) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentFamilia3Q(),
                    args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentFamilia3Q(),
                    args
                )
            }
        }
        return rootView
    }
}