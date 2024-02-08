package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica2

class FragmentDinamica2v1 : Fragment() {
    lateinit var btnYuxcha: Button
    lateinit var btnAllchhi: Button
    lateinit var btnTullqa: Button
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_familia5, container, false)
        iniciarComponentes()

      /*  opcionMultipleDePalabras().palabraVerdaderaLL(
            palabraCorrecta = btnYuxcha.text.toString(),
            btnYuxcha,
            btnAllchhi,
            btnTullqa,
        )*/

        return rootView
    }

    private fun iniciarComponentes() {
        btnYuxcha = rootView.findViewById(R.id.btnY)
        btnAllchhi = rootView.findViewById(R.id.btnAlch)
        btnTullqa = rootView.findViewById(R.id.btnTull)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica2(this).configurar()
    }
}