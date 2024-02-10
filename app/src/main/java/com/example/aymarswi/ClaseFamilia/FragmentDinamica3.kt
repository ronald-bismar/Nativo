package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica3


class FragmentDinamica3 : Fragment() {
    lateinit var obText: EditText
    lateinit var btnComprobar: Button
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_dinamica3, container, false)
        iniciarComponentes()

        return rootView
    }


    private fun iniciarComponentes() {
        btnComprobar = rootView.findViewById(R.id.btnComprobar3)
        obText = rootView.findViewById(R.id.txtRespuesta3)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica3(this).configurar()
    }
}