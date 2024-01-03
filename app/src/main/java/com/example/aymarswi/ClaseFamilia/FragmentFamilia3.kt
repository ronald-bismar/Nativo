package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras


class FragmentFamilia3 : Fragment() {
    private lateinit var obText: EditText
    private lateinit var btnComprobar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_familia3, container, false)
        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            "jila",
            "jilata",
            palabraElegida = obText,
            botonComprobar = btnComprobar,
            activity =  requireActivity() as AppCompatActivity
        )

        return rootView
    }


    private fun iniciarComponentes() {
        btnComprobar = requireView().findViewById(R.id.btnComp1)
        obText = requireView().findViewById(R.id.txtResp1)
    }
}