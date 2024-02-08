package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia8 : Fragment() {

    lateinit var btnTiwula3: Button
    lateinit var btnKullaka2: Button
    lateinit var btnJila1: Button
    lateinit var btnIpa: Button
    lateinit var btnComprobar: Button
    lateinit var etPalabra: TextView
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia8, container, false)
        iniciarComponentes()

        /*opcionMultipleDePalabras().palabraVerdadera(
            btnTiwula3,
            btnKullaka2,
            btnJila1,
            btnIpa,
            palabraCorrecta = btnJila1.text.toString(),
            palabraElegida = etPalabra,
            botonComprobar = btnComprobar
        )*/

        return rootView
    }

    private fun iniciarComponentes() {
        btnTiwula3 = rootView.findViewById(R.id.btnTiwula3)
        btnKullaka2 = rootView.findViewById(R.id.btnKullaka2)
        btnJila1 = rootView.findViewById(R.id.btnJila1)
        btnIpa = rootView.findViewById(R.id.btnIpa)
        etPalabra = rootView.findViewById(R.id.etContenPalabra)
        btnComprobar = rootView.findViewById(R.id.btnComprobar15)
    }
}