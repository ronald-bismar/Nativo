package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import android.util.Log
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
    private lateinit var rootView: View
    private lateinit var btnIAymara : Button
    private lateinit var btnIQuechua: Button

    companion object{
        lateinit var Idioma: String
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_seleccionar_idioma, container, false)

        initComponents()
        val user = SharedPreferencesUsers.getProfileOfPreferences(requireContext())
        Log.d("Preferences", "nombre: ${user.name}")
        Log.d("Preferences", "correo: ${user.email}")
        Log.d("Preferences", "contraseña: ${user.password}")
        Log.d("Preferences", "level: ${user.level}")
        Log.d("Preferences", "imageProfileRound: ${user.imageProfileR}")
        Log.d("Preferences", "imageProfileSquare: ${user.imageProfileC}")
        Log.d("Preferences", "estrellas: ${user.estrellas}")
        Log.d("Preferences", "trofeos: ${user.trofeos}")
        Log.d("Preferences", "medallasDoradas: ${user.medallasDoradas}")
        Log.d("Preferences", "medallasPlateadas: ${user.medallasPlateadas}")
        clickButtons()



        return rootView
    }

    private fun changeFragmentLocal(fragment: Fragment) {
        TransactionFragment.changeFragment(requireActivity() as AppCompatActivity, fragment, R.id.ContenedorP_Principales)
    }

    private fun clickButtons() {
        btnIAymara.setOnClickListener {
            Idioma = "Aymara"
            changeFragmentLocal(FragmentAimara())
        }

        btnIQuechua.setOnClickListener {
            Idioma = "Quechua"
            changeFragmentLocal(FragmentQuechua())
        }
    }

    private fun initComponents() {
        btnIAymara = rootView.findViewById(R.id.btnIAymara)
        btnIQuechua = rootView.findViewById(R.id.btnIQuechua)
    }
}