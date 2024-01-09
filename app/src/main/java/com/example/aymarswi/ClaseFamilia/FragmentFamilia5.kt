package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia5 : Fragment() {
    private lateinit var btnYuxcha: Button
    private lateinit var btnAllchhi: Button
    private lateinit var btnTullqa: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_familia5, container, false)
        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            palabraCorrecta = btnYuxcha.text.toString(),
            btnYuxcha,
            btnAllchhi,
            btnTullqa,
        )

        return rootView
    }

    private fun iniciarComponentes() {
        btnYuxcha = rootView.findViewById(R.id.btnY)
        btnAllchhi = rootView.findViewById(R.id.btnAlch)
        btnTullqa = rootView.findViewById(R.id.btnTull)
    }
}