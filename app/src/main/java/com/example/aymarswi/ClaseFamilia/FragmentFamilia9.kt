package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.OrdenarPalabras
import com.google.android.flexbox.FlexboxLayout

class FragmentFamilia9 : Fragment() {

    private lateinit var btnComprobar: Button
    private lateinit var contenedorOracionRespuesta: LinearLayout
    private lateinit var contenedorPalabras: FlexboxLayout
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia9, container, false)

        initComponents()

        OrdenarPalabras(contenedorPalabras, contenedorOracionRespuesta, btnComprobar).initDynamic("Allchhi", )
            return rootView
        }

    private fun initComponents() {
        btnComprobar = rootView.findViewById(R.id.btnComprobar16)
        contenedorOracionRespuesta = rootView.findViewById(R.id.etContenPalabra)
        contenedorPalabras = rootView.findViewById(R.id.constraintLayout6)
    }
}