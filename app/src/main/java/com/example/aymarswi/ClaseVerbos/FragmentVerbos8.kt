package com.example.aymarswi.ClaseVerbos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentVerbos8 : Fragment() {
    private lateinit var wordsContainer: LinearLayout
    private lateinit var sentenceContainer: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_verbos8, container, false)
        //Acceder a los valores enviado desde el anterior fragment


        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        wordsContainer = rootView.findViewById(R.id.wordsContainer)
        sentenceContainer = rootView.findViewById(R.id.sentenceContainer)
        val btnComprobar: Button = rootView.findViewById(R.id.btnComprobar1)
        val words = listOf("anatt’apxi", "pusinix")
        Utils().ordenarPalabras(
            words,
            requireContext() as AppCompatActivity,
            wordsContainer,
            sentenceContainer
        )
        btnComprobar.setOnClickListener {
            if (Utils().obtenerOracionFormada(sentenceContainer) == "pusinix anatt’apxi") {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentVerbos9(),
                    args
                )
            } else {
                args.putInt("valorc", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentVerbos9(),
                    args
                )
            }
        }
        return rootView
    }
}
