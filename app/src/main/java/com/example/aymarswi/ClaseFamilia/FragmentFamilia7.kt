package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia7 : Fragment() {

    private lateinit var btnTayka: Button
    private lateinit var btnTiwula: Button
    private lateinit var btnIpa: Button
    private lateinit var btnKullaka: Button
    private lateinit var btnComprobar: Button
    private lateinit var etPalabra: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_familia7, container, false)

        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            btnTayka,
            btnTiwula,
            btnIpa,
            btnKullaka,
            palabraCorrecta = btnKullaka.text.toString(),
            palabraElegida = etPalabra,
            botonComprobar = btnComprobar, activity = requireActivity() as AppCompatActivity
        )

        return rootView
    }

    private fun iniciarComponentes() {
        btnTayka = requireView().findViewById(R.id.btnTayka)
        btnTiwula = requireView().findViewById(R.id.btnTiwula)
        btnIpa = requireView().findViewById(R.id.btnIpa)
        btnKullaka = requireView().findViewById(R.id.btnKullaka)
        etPalabra = requireView().findViewById(R.id.etPalabra)
        btnComprobar = requireView().findViewById(R.id.appCompatButton8)
    }
}