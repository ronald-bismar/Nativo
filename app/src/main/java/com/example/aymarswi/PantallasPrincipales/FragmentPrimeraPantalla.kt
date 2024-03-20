package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R

class FragmentPrimeraPantalla : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView =  inflater.inflate(R.layout.fragment_primera_pantalla, container, false)
        val btnIngresar = rootView.findViewById<Button>(R.id.botonIngresar)
        val btnRegistrarse = rootView.findViewById<Button>(R.id.botonRegistrarse)

        btnIngresar.setOnClickListener {
//            Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.ContenedorP_Principales, Fragment_Ingresar())
        }

        btnRegistrarse.setOnClickListener {
//            Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.ContenedorP_Principales, FragmentRegistro())
        }

        return rootView
    }
}