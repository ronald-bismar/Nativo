package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia6 : Fragment() {

    private lateinit var txtPalabra: TextView
    private lateinit var btnSarañani: Button
    private lateinit var btnUrukipan: Button
    private lateinit var btnArsuña: Button
    private lateinit var btnComprobar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_familia6, container, false)
        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            btnSarañani,
            btnUrukipan,
            btnArsuña,
            palabraCorrecta = btnUrukipan.text.toString(),
            palabraElegida = txtPalabra,
            botonComprobar = btnComprobar,
        )

        return rootView
    }

    private fun iniciarComponentes() {
        btnSarañani = requireView().findViewById(R.id.btnsarañani)
        btnUrukipan = requireView().findViewById(R.id.btnurukipan)
        btnArsuña = requireView().findViewById(R.id.btnparlaña)
        txtPalabra = requireView().findViewById(R.id.txtpalabra)
        btnComprobar = requireView().findViewById(R.id.btnCmpb)
    }
}