package com.example.aymarswi.ClaseNumeros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.model.textoLecciones.Dinamica9

class FragmentNumeros : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_numeros, container, false)
        val txtMaya = rootView.findViewById<TextView>(R.id.txtMaya)
        val txtPaya = rootView.findViewById<TextView>(R.id.txtPaya)
        val txtQimsa = rootView.findViewById<TextView>(R.id.txtQimsa)
        val txtPusi = rootView.findViewById<TextView>(R.id.txtPusi)
        val txtCPalabra1 = rootView.findViewById<TextView>(R.id.txtCPalabra1)
        val txtCPalabra2 = rootView.findViewById<TextView>(R.id.txtCPalabra2)
        val txtCPalabra3 = rootView.findViewById<TextView>(R.id.txtCPalabra3)
        val txtCPalabra4 = rootView.findViewById<TextView>(R.id.txtCPalabra4)

        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)


        Utils().deslizar4PalabrasA4Contenedores(
            requireActivity() as AppCompatActivity,
            txtMaya,
            txtPaya,
            txtQimsa,
            txtPusi,
            txtCPalabra1,
            txtCPalabra2,
            txtCPalabra3,
            txtCPalabra4,
            txtMaya.text.toString(),
            txtPaya.text.toString(),
            txtQimsa.text.toString(),
            txtPusi.text.toString(),
            R.id.contenedorDeFragments,
            FragmentNumeros2(), args, puntaje
        )
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica9(this)
    }
}