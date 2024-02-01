package com.example.aymarswi.ClaseAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
class FragmentAnimales10 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_animales10, container, false)
        val palabra1 = rootView.findViewById<TextView>(R.id.palabra1)//phisi
        val palabra2 = rootView.findViewById<TextView>(R.id.palabra2)//luli
        val palabra3 = rootView.findViewById<TextView>(R.id.palabra3)//katari
        val palabra4 = rootView.findViewById<TextView>(R.id.palabra4)//wallpa
        val btnContinuar = rootView.findViewById<Button>(R.id.btnContinuar)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        args.putInt("valorp", ++puntaje)
        Utils().sopaDeLetras(
            R.id.l1,
            R.id.l2,
            R.id.l3,
            R.id.l4,
            R.id.l5,
            R.id.l6,
            R.id.l7,
            R.id.l8,
            R.id.l9,
            R.id.l10,
            R.id.l11,
            R.id.l12,
            R.id.l13,
            R.id.l14,
            R.id.l15,
            R.id.l16,
            R.id.l17,
            R.id.l18,
            R.id.l19,
            R.id.l20,
            R.id.l21,
            R.id.l22,
            R.id.l23,
            R.id.l24,
            R.id.l25,
            requireContext(),
            rootView,palabra1,
            palabra2,palabra3,
            palabra4, btnContinuar, 'u', requireActivity() as AppCompatActivity, R.id.contenedorDeFragments, FragmentAnimales10(), args)
        return rootView  }
}