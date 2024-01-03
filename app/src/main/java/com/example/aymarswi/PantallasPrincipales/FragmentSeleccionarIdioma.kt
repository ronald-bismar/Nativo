package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSeleccionarIdioma : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_seleccionar_idioma, container, false)

        val btnIAymara = rootView.findViewById<Button>(R.id.btnIAymara)
        val btnIQuechua = rootView.findViewById<Button>(R.id.btnIQuechua)

        btnIAymara.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.ContenedorP_Principales,
                FragmentAimara()
            )
        }

        btnIQuechua.setOnClickListener {

            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.ContenedorP_Principales,
                FragmentQuechua()
            )
        }

        return rootView
    }
}