package com.example.aymarswi.QuechuaSaludos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseSaludos.Saludos6
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludo5Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_saludo5_q, container, false)
        val btnJaypu = rootView.findViewById<Button>(R.id.btnJaypu)
        val btnAroma = rootView.findViewById<Button>(R.id.btnAroma)
        val etJaypu = rootView.findViewById<TextView>(R.id.etJaypu)
        val btnrespuesta = rootView.findViewById<Button>(R.id.btnrespuesta)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val args = Bundle()
        args.putInt("valorc", ++contador)

        btnJaypu.setOnClickListener {
            etJaypu.text = btnJaypu.text.toString()
        }
        btnAroma.setOnClickListener {
            etJaypu.text = btnAroma.text.toString()
        }
        btnrespuesta.setOnClickListener {
            if (etJaypu.text.toString() == btnJaypu.text.toString()) {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireContext() as AppCompatActivity, R.id.fragmentContainerView3,
                    FragmentSaludo6Q(), args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity, R.id.fragmentContainerView3,
                    FragmentSaludo6Q(), args
                )
            }
        }
        return rootView   }
}