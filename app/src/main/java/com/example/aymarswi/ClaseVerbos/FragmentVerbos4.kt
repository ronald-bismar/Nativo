package com.example.aymarswi.ClaseVerbos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos4 : Fragment() {
    private lateinit var wordsContainer: LinearLayout
    private lateinit var sentenceContainer: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_verbos4, container, false)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        wordsContainer = rootView.findViewById(R.id.wordsContainer)
        sentenceContainer = rootView.findViewById(R.id.sentenceContainer)
        val btnComprobar: Button = rootView.findViewById(R.id.btnComprobar1)
        val words = listOf("papá", "Mi", "conduce", "camina")

        Utils().ordenarPalabras(words,requireContext() as AppCompatActivity, wordsContainer, sentenceContainer)

        btnComprobar.setOnClickListener {
            val oracionObtenida = Utils().obtenerOracionFormada(sentenceContainer)
            if(oracionObtenida == "Mi papá conduce"){
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(requireContext() as AppCompatActivity, R.id.contenedorDeFragments, FragmentVerbos5(), args)
            }else{
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(requireContext() as AppCompatActivity, R.id.contenedorDeFragments, FragmentVerbos5(), args)
            }
        }
        return rootView
    }
}





