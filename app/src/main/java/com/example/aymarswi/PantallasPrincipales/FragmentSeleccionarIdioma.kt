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
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers

class FragmentSeleccionarIdioma : Fragment() {

    companion object{
        var Idioma: String = "Quechua"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_seleccionar_idioma, container, false)

        /*SharedPreferencesUsers.updatePreferences(requireContext(), )*/

        val btnIAymara = rootView.findViewById<Button>(R.id.btnIAymara)
        val btnIQuechua = rootView.findViewById<Button>(R.id.btnIQuechua)

        btnIAymara.setOnClickListener {
            Idioma = "Aymara"
            TransactionFragment.changeFragment(requireActivity() as AppCompatActivity, FragmentAimara(), R.id.ContenedorP_Principales)
        }

        btnIQuechua.setOnClickListener {
            Idioma = "Quechua"
            TransactionFragment.changeFragment(requireActivity() as AppCompatActivity, FragmentQuechua(), R.id.ContenedorP_Principales)

        }

        return rootView
    }
}