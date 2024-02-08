package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentFamilia6Q : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_familia6_q, container, false)
        val btnSarañani = rootView.findViewById<Button>(R.id.btnsarañani)
        val btnUrukipan = rootView.findViewById<Button>(R.id.btnurukipan)
        val btnParlaña = rootView.findViewById<Button>(R.id.btnparlaña)
        val txtPalabra = rootView.findViewById<TextView>(R.id.txtRespuesta5)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar5)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        Log.d("Fragment2", "Puntaje recibido: $puntaje")
        Log.d("Fragment2", "Contador recibido: $contador")
        btnSarañani.setOnClickListener{
            txtPalabra.text = "sarañani"
        }
        btnUrukipan.setOnClickListener {
            txtPalabra.text = "urukïpan"
        }
        btnParlaña.setOnClickListener {
            txtPalabra.text = "parlaña"
        }
        btnComprobar.setOnClickListener {
            if(txtPalabra.text == "urukïpan") {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentFamilia9Q(),args)
            }
            else if(txtPalabra.text == "sarañani" || txtPalabra.text == "parlaña") {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentFamilia9Q(),args)
            }
        }
        return rootView
    }
}