package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentFamilia10Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_familia10_q, container, false)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val btnKullaka4 = rootView.findViewById<Button>(R.id.btnKullaka4)
        val btnJila = rootView.findViewById<Button>(R.id.btnJila)
        val btnJilaku = rootView.findViewById<Button>(R.id.btnJilaku)
        val btnAchachila = rootView.findViewById<Button>(R.id.btnAchachila)
        val etPalabra3 = rootView.findViewById<TextView>(R.id.etContenPalabra)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar17)
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnKullaka4.setOnClickListener {
            etPalabra3.text = btnKullaka4.text.toString()
        }
        btnJila.setOnClickListener {
            etPalabra3.text = btnJila.text.toString()
        }
        btnJilaku.setOnClickListener {
            etPalabra3.text = btnJilaku.text.toString()
        }
        btnAchachila.setOnClickListener {
            etPalabra3.text = btnAchachila.text.toString()
        }
        etPalabra3.setOnClickListener {
            etPalabra3.text = ""
        }

        btnComprobar.setOnClickListener {
            if (etPalabra3.text.toString() == btnJilaku.text.toString()) {
                if(contador == 10){
                    Utils().sonidoCorrecto(requireContext())
                    Utils().alertDialogCorrectDeterminaResultado(
                        requireContext(), ++puntaje,
                        requireActivity() as AppCompatActivity, R.id.contenedorDeFragments)
                }
                else {
                    args.putInt("valorp", puntaje)
                    Utils().alertDialogCorrectDeterminaResultado(
                        requireContext(), puntaje,
                        requireActivity() as AppCompatActivity, R.id.contenedorDeFragments)

                }
            }
        }
        return rootView  }
}