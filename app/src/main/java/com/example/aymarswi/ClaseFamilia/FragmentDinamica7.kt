package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica7
import com.google.android.flexbox.FlexboxLayout

class FragmentDinamica7 : Fragment() {

    lateinit var btnComprobar: Button
    lateinit var contenedorOracionRespuesta: LinearLayout
    lateinit var contenedorPalabras: FlexboxLayout
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_familia9, container, false)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Dinamica7(this)
    }
}