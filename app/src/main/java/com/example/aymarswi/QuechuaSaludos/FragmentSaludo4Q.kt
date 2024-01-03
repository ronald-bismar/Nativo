package com.example.aymarswi.QuechuaSaludos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseSaludos.FragmentSaludos5
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludo4Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_saludo4_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnnoches = rootView.findViewById<Button>(R.id.btnnoches);
        val btndias = rootView.findViewById<Button>(R.id.btndias)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnnoches.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo5Q(),
                args
            )
        }
        btndias.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireContext() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentSaludo5Q(),
                args
            )
        }
        return rootView    }
}