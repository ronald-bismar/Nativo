package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class PalabrasDeLaLeccion : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_palabras_leccion_familia, container, false)
        val btnContinuar = rootView.findViewById<Button>(R.id.btnEmpezarLecciones)
        btnContinuar.setOnClickListener {
            Utils().pasarDeFragment(requireActivity() as
                    AppCompatActivity, R.id.contenedorDeFragments,
                FragmentPalabrasDeLeccion())

        }

        return rootView
    }
}