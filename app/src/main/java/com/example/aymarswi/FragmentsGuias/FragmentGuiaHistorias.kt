
package com.example.aymarswi.FragmentsGuias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.Historias.FragmentHistorias
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentGuiaHistorias : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_guia_historias, container, false)
        val botonEmpezar = rootView.findViewById<Button>(R.id.btnEmpezarHistorias)

        botonEmpezar.setOnClickListener {
            Utils().pasarDeFragment(requireActivity() as
                    AppCompatActivity,R.id.contenedorDeFragments, FragmentHistorias())
        }
        return rootView
    }
}