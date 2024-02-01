package com.example.aymarswi.ClaseSaludos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludos3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_saludos3, container, false)
        val btnjaypukypan = rootView.findViewById<Button>(R.id.btnjaypukypan)
        val btnSarañani = rootView.findViewById<Button>(R.id.btnSarañani)
        val btnaromakipan = rootView.findViewById<Button>(R.id.btnaromakipan)
        val txtPalabra = rootView.findViewById<TextView>(R.id.txtpalabra2)
        val btnComprobar = rootView.findViewById<Button>(R.id.btn)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        Log.d("Fragment2", "Puntaje recibido: $puntaje")
        Log.d("Fragment2", "Contador recibido: $contador")
        btnSarañani.setOnClickListener{
            txtPalabra.text = btnSarañani.text.toString()
        }
        btnjaypukypan.setOnClickListener {
            txtPalabra.text = btnjaypukypan.text.toString()
        }
        btnaromakipan.setOnClickListener {
            txtPalabra.text = btnaromakipan.text.toString()
        }
        btnComprobar.setOnClickListener {
            if(txtPalabra.text.toString() ==  btnaromakipan.text.toString()) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(requireContext() as AppCompatActivity,R.id.contenedorDeFragments,
                    FragmentSaludos4(),args)
            }
            else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(requireContext() as AppCompatActivity,R.id.contenedorDeFragments,
                    FragmentSaludos4(),args)
            }
        }
        return rootView  }
}