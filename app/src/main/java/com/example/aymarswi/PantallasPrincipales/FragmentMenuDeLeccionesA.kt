package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.aymarswi.ClaseFamilia.FragmentFamilia1
import com.example.aymarswi.R

class FragmentMenuDeLeccionesA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_menu_de_lecciones, container, false)

        val imgBoton = rootView.findViewById<ImageButton>(R.id.imgBtnFamilia);
        val imgBoton2 = rootView.findViewById<ImageButton>(R.id.imgBtnNaturaleza);
        val imgBoton3 = rootView.findViewById<ImageButton>(R.id.imgBtnSaludos);
        val imgBoton4 = rootView.findViewById<ImageButton>(R.id.imgBtnAnimales);
        val imgBoton5 = rootView.findViewById<ImageButton>(R.id.imgBtnVerbos);
        val imgBoton6 = rootView.findViewById<ImageButton>(R.id.imgBtnColores);
        val imgBoton7 = rootView.findViewById<ImageButton>(R.id.imgBtnNumeros);
        val imgBoton8 = rootView.findViewById<ImageButton>(R.id.imgBtnObjetos);
        imgBoton.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 1)
            startActivity(intent)

            /* val fragmentManager = requireActivity().supportFragmentManager
             val transaccion = fragmentManager.beginTransaction()
             transaccion.replace(R.id.ContenedorP_Principales, FragmentFamilia1())
             transaccion.commit()*/
        }
        imgBoton2.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 2)
            startActivity(intent)
        }
        imgBoton3.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 3)
            startActivity(intent)
        }
        imgBoton4.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 4)
            startActivity(intent)
        }
        imgBoton5.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 5)
            startActivity(intent)
        }
        imgBoton6.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 6)
            startActivity(intent)
        }
        imgBoton7.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 7)
            startActivity(intent)
        }
        imgBoton8.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 8)
            startActivity(intent)
        }

        return rootView
    }
}