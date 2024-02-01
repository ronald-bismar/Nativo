package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.util.Log
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
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia3, container, false)
        iniciarComponentes()
        Actividad.setContext(requireActivity() as AppCompatActivity, requireContext(), R.id.contenedorDeFragments)

        opcionMultipleDePalabras().palabraVerdadera(
            "jila",
            "jilata",
            palabraElegida = obText,
            botonComprobar = btnComprobar,
        )
        return rootView
    }


    private fun iniciarComponentes() {
        btnComprobar = rootView.findViewById(R.id.btnComp1)
        obText = rootView.findViewById(R.id.txtResp1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Contexto","posicion actual: ${Actividad.getInstanceActividad().posicionDeLaRutaDeFragments}")
    }
}