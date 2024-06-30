package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.aymarswi.ApiRest.User
import com.example.aymarswi.R
import com.example.aymarswi.model.TransactionFragment
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers

class FragmentPrimeraPantalla : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_primera_pantalla, container, false)
        session()
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

    private fun session() {

        val user: User = SharedPreferencesUsers.getProfileOfPreferences(requireContext())
        if (user.email != "") {
            val intent = Intent(
                requireContext(),
                if (FragmentSeleccionarIdioma.Idioma == "Aymara") MenuEleccion::class.java else MenuEleccionQ::class.java
            )
            startActivity(intent)
        }
    }
}