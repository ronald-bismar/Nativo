package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.PantallasPrincipales.ActivityContenedor.Companion.actividad
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia2 : Fragment() {

    private lateinit var btnTayka: Button
    private lateinit var btnKullaka: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia2, container, false)

        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(btnTayka.text.toString(), btnTayka, btnKullaka, activity =  requireActivity() as AppCompatActivity)

        return rootView
    }

    private fun iniciarComponentes() {
        btnTayka = rootView.findViewById(R.id.btnTayka)
        btnKullaka = rootView.findViewById(R.id.btnKullaka)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*Log.d("Mensaje","Fragment2 iniciado")
        Log.d("Lista","Lista de Fragments: ${Actividad.getInstance().rutaDeFragments.count()}")
        Log.d("Lista","Lista de Fragments: ${Actividad.getInstance().activity}")
        Log.d("Lista","Lista de Fragments: ${Actividad.getInstance().rutaDeFragments.count()}")*/

        Log.d("Contexto","posicion actual: ${actividad.posicionDeLaRutaDeFragments}")

        /*Log.d("Contexto","contexto: ${Actividad.getInstance().rutaDeFragments[Actividad.getInstance().posicionDeLaRutaDeFragments-1].requireContext()}")
        Log.d("Contexto","contexto actual: ${requireContext()}")*/



    }
}