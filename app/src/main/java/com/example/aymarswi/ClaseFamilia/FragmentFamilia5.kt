package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentFamilia5 : Fragment() {
    private lateinit var btnYuxcha: Button
    private lateinit var btnAllchhi: Button
    private lateinit var btnTullqa: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.fragment_familia5, container, false)
        iniciarComponentes()

        opcionMultipleDePalabras().palabraVerdadera(
            palabraCorrecta = btnYuxcha.text.toString(),
            btnYuxcha,
            btnAllchhi,
            btnTullqa,
            activity = requireActivity() as AppCompatActivity
        )

        return rootView
    }

    private fun iniciarComponentes() {
        btnYuxcha = requireView().findViewById(R.id.btnY)
        btnAllchhi = requireView().findViewById(R.id.btnAlch)
        btnTullqa = requireView().findViewById(R.id.btnTull)
    }
}