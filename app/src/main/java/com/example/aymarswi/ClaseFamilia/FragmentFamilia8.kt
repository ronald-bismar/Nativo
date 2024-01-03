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

class FragmentFamilia8 : Fragment() {

    private lateinit var btnTiwula3: Button
    private lateinit var btnKullaka2: Button
    private lateinit var btnJila1: Button
    private lateinit var btnIpa: Button
    private lateinit var btnComprobar: Button
    private lateinit var etPalabra: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_familia8, container, false)
        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            btnTiwula3,
            btnKullaka2,
            btnJila1,
            btnIpa,
            palabraCorrecta = btnJila1.text.toString(),
            palabraElegida = etPalabra,
            botonComprobar = btnComprobar, activity = requireActivity() as AppCompatActivity
        )

        return rootView
    }

    private fun iniciarComponentes() {
        btnTiwula3 = requireView().findViewById(R.id.btnTiwula3)
        btnKullaka2 = requireView().findViewById(R.id.btnKullaka2)
        btnJila1 = requireView().findViewById(R.id.btnJila1)
        btnIpa = requireView().findViewById(R.id.btnIpa)
        etPalabra = requireView().findViewById(R.id.etContenPalabra)
        btnComprobar = requireView().findViewById(R.id.btnComprobar15)
    }
}