package com.example.aymarswi.QuechuaAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseAnimales.FragmentAnimales6
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales5Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_animales5_q, container, false)
        val txtCPalabra3 = rootView.findViewById<LinearLayout>(R.id.txtCPalabra3)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar10)
        val palabraCorrecta = rootView.findViewById<TextView>(R.id.txtPilpintu)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)

        val oracionOriginal =  palabraCorrecta.text.toString()
        Utils().formarOracionCon4Botones(
            R.id.txtAchaku,
            R.id.txtPilpintu,
            R.id.txtPhisi,
            R.id.txtJampatu,
            oracionOriginal,
            rootView,
            txtCPalabra3,
            btnComprobar,
            requireActivity() as AppCompatActivity,
            FragmentAnimales6Q(),
            R.id.fragmentContainerView3,
            args, puntaje,
            1)
        return rootView  }
}