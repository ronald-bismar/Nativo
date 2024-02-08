package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras
import com.example.aymarswi.model.textoLecciones.Dinamica2

class FragmentDinamica2 : Fragment() {

    lateinit var title: TextView
    lateinit var btnTayka: Button
    lateinit var btnKullaka: Button
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia2, container, false)

        iniciarComponentes()

        return rootView
    }

    private fun iniciarComponentes() {
        btnTayka = rootView.findViewById(R.id.btnTayka)
        btnKullaka = rootView.findViewById(R.id.btnKullaka)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica2(this).configurar()
    }
}