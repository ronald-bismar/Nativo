package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica4

class FragmentDinamica4 : Fragment() {

    lateinit var obText: EditText
    lateinit var btnComprobar: Button
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_familia4, container, false)
        iniciarComponentes()

        /*opcionMultipleDePalabras().palabraVerdadera(
            "buen dia hermano",
            "buenos dias hermano",
            palabraElegida = obText, botonComprobar =  btnComprobar
        )*/

        return rootView
    }

    private fun iniciarComponentes() {
        btnComprobar = rootView.findViewById(R.id.btnComprobar4)
        obText = rootView.findViewById(R.id.txtRespuesta4)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica4(this).configurar()
    }
}