package com.example.aymarswi.FragmentsGuias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.PantallasPrincipales.FragmentMenuDeLeccionesA
import com.example.aymarswi.PantallasPrincipales.FragmentMenuDeLeccionesQ
import com.example.aymarswi.R

class FragmentGuiaLecciones : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_guia_lecciones, container, false)
        val botonEmpezar = rootView.findViewById<Button>(R.id.btnEmpezarLecciones)

        val valorRecibido = arguments?.getInt("clave_valor",0)
        botonEmpezar.setOnClickListener {
            if(valorRecibido == 30){
//                Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.ContenedorP_Principales,FragmentMenuDeLeccionesA())
            }
            else{
//                Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.ContenedorP_Principales,FragmentMenuDeLeccionesQ())
            }
        }




        return rootView
    }
    companion object {
        fun newInstance(valor: Int): FragmentGuiaLecciones {
            val fragment = FragmentGuiaLecciones()
            val args = Bundle()
            args.putInt("clave_valor", valor)
            fragment.arguments = args
            return fragment
        }
    }
}