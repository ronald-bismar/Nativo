package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia4 : Fragment() {

    private lateinit var obText: EditText
    private lateinit var btnComprobar: Button
    private lateinit var palabra: String
    private var correcto: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_familia4, container, false)
        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            "buen dia hermano",
            "buenos dias hermano",
            "buen dia hermana",
            "buenos dias hermana",
            "buen día hermano",
            "buenos días hermano",
            "buen día hermana",
            "buenos días hermana",
            palabraElegida = obText, botonComprobar =  btnComprobar, activity = requireActivity() as AppCompatActivity
        )

        return rootView
    }

    private fun iniciarComponentes() {
        btnComprobar = requireView().findViewById(R.id.btnCpb)
        obText = requireView().findViewById(R.id.txtTexto)
    }
}