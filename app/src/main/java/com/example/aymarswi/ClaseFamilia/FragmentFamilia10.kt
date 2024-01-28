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
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia10 : Fragment() {
    private lateinit var btnKullaka4: Button
    private lateinit var btnJila : Button
    private lateinit var  btnJilaku: Button
    private lateinit var btnAchachila: Button
    private lateinit var etPalabra3: TextView
    private lateinit var btnComprobar: Button
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_familia10, container, false)
        initComponents()
        opcionMultipleDePalabras().palabraVerdadera(
            btnKullaka4,
            btnJila,
            btnJilaku,
            btnAchachila,
            palabraCorrecta = btnJilaku.text.toString(),
            palabraElegida = etPalabra3,
            botonComprobar = btnComprobar
        )
        return rootView  }

    private fun initComponents() {
        btnKullaka4 = rootView.findViewById(R.id.btnKullaka4)
        btnJila = rootView.findViewById(R.id.btnJila)
        btnJilaku = rootView.findViewById(R.id.btnJilaku)
        btnAchachila = rootView.findViewById(R.id.btnAchachila)
        etPalabra3 = rootView.findViewById(R.id.etContenPalabra)
        btnComprobar = rootView.findViewById(R.id.btnComprobar17)
    }
}