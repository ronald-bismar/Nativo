package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentFamilia4Q : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_familia4_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Fragment2", "Puntaje recibido: $puntaje")
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar4)
        val obText = rootView.findViewById<EditText>(R.id.txtRespuesta4)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnComprobar.setOnClickListener{
            if(obText.text.isNotEmpty()) {
                if (((((obText.text).toString()).trim()).lowercase()) == ("buenos dias hermano") || ((((obText.text).toString()).trim()).lowercase())==("buenos días hermano")) {
                    args.putInt("valorp", ++puntaje)
                    Utils().respuestaCorrecta(
                        requireContext() as AppCompatActivity,
                        R.id.contenedorDeFragments,
                        FragmentFamilia5Q(), args)
                } else {
                    args.putInt("valorp", puntaje)
                    Utils().respuestaIncorrecta(
                        requireContext() as AppCompatActivity,
                        R.id.contenedorDeFragments,
                        FragmentFamilia5Q(), args)
                }
            }else{
                Utils().mostrarMensajeETextVacio(requireContext() as AppCompatActivity)
            }
        }
        return rootView
    }
}