package com.example.aymarswi.QuechuaNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNaturaleza8Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza8_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComp2)
        val obText = rootView.findViewById<EditText>(R.id.txtResp2)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnComprobar.setOnClickListener{
            if(obText.text.isNotEmpty()) {
                if (((((obText.text).toString()).trim()).lowercase()) == ("sach'a") || ((((obText.text).toString()).trim()).lowercase()) == "alli") {
                    args.putInt("valorp", ++puntaje)
                    Utils().respuestaCorrecta(requireContext() as AppCompatActivity,
                        R.id.contenedorDeFragments, FragmentNaturaleza9Q(), args)
                } else {
                    args.putInt("valorp", puntaje)
                    Utils().respuestaIncorrecta(requireContext() as AppCompatActivity,
                        R.id.contenedorDeFragments, FragmentNaturaleza9Q(), args)
                }
            }else{
                Utils().mostrarMensajeETextVacio(requireContext() as AppCompatActivity)
            }
        }
        return rootView   }

}