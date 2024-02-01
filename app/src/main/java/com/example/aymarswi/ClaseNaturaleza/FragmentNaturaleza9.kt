package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentNaturaleza9 : Fragment() {
    private lateinit var btnPanqa: Button
    private lateinit var btnAli: Button
    private lateinit var btnChuqi1: Button
    private lateinit var btnKhunu: Button
    private lateinit var imgVSonido: ImageView
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_naturaleza9, container, false)
        initComponents()

        opcionMultipleDePalabras().palabraVerdadera(btnChuqi1.text.toString(), btnPanqa, btnAli, btnChuqi1, btnKhunu)

        return rootView
    }

    private fun initComponents() {
        btnPanqa = rootView.findViewById(R.id.btnPanqa)
        btnAli = rootView.findViewById(R.id.btnAli1)
        btnChuqi1 = rootView.findViewById(R.id.btnChuqi1)
        btnKhunu = rootView.findViewById(R.id.btnKhunu1)
        imgVSonido = rootView.findViewById(R.id.imgVSonido)
    }
}