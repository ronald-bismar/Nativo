package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica5

class FragmentDinamica5 : Fragment() {

    lateinit var contOracionIncompleta: LinearLayout
    lateinit var opciones: LinearLayout
    lateinit var btnComprobar5: Button
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_dinamica5, container, false)
        iniciarComponentes()

        return rootView
    }

    private fun iniciarComponentes() {
        contOracionIncompleta = rootView.findViewById(R.id.llOracionIncompleta)
        opciones = rootView.findViewById(R.id.llBotones)
        btnComprobar5 = rootView.findViewById(R.id.btnComprobar5)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica5(this)
    }
}