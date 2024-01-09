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

class FragmentFamilia9 : Fragment() {

    private lateinit var btnComprobar: Button
    private lateinit var contenedorOracion: LinearLayout
    private lateinit var contenedorPalabras: LinearLayout
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia9, container, false)

        initComponents()

        OrdenarPalabras().initDynamic("Allchhi", contenedorPalabras, contenedorOracion)
            return rootView
        }

    private fun initComponents() {
        btnComprobar = rootView.findViewById(R.id.btnComprobar16)
        contenedorOracion = rootView.findViewById(R.id.etContenPalabra)
        contenedorPalabras = rootView.findViewById(R.id.constraintLayout6)
    }
}