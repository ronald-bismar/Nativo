package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica1

open class FragmentDinamica1 : Fragment() {

    lateinit var title: TextView
    lateinit var opciones: MutableList<LinearLayout>
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_dinamica1, container, false)

        initComponents()

        return rootView
    }

    private fun initComponents() {
        title = rootView.findViewById(R.id.txtTitle1)
        opciones =
            mutableListOf(rootView.findViewById(R.id.llPapa), rootView.findViewById(R.id.llHermano))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Dinamica1(this).configurar()
    }
}