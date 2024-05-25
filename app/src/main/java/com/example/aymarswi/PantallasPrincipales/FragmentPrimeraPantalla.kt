package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.model.TransactionFragment

class FragmentPrimeraPantalla : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_primera_pantalla, container, false)

        rootView.findViewById<Button>(R.id.botonIngresar).setOnClickListener {
            pasarAFragment(Fragment_Ingresar())
        }

        rootView.findViewById<Button>(R.id.botonRegistrarse).setOnClickListener {
            pasarAFragment(FragmentRegistro())
        }

        return rootView
    }

    private fun pasarAFragment(fragment: Fragment) {
        TransactionFragment.changeFragment(
            requireActivity() as AppCompatActivity,
            fragment,
            R.id.ContenedorP_Principales
        )
    }
}