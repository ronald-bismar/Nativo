package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.aymarswi.R
class FragmentMenuDeLeccionesQ : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_menu_de_lecciones_q, container, false)

        val imgBoton8 = rootView.findViewById<ImageButton>(R.id.imgBtnFamilia);
        val imgBoton9 = rootView.findViewById<ImageButton>(R.id.imgBtnNaturaleza);
        val imgBoton10 = rootView.findViewById<ImageButton>(R.id.imgBtnSaludos);
        val imgBoton11 = rootView.findViewById<ImageButton>(R.id.imgBtnAnimales);
        val imgBoton12 = rootView.findViewById<ImageButton>(R.id.imgBtnVerbos);
        val imgBoton13 = rootView.findViewById<ImageButton>(R.id.imgBtnColores);
        val imgBoton14 = rootView.findViewById<ImageButton>(R.id.imgBtnNumeros);
        val imgBoton15 = rootView.findViewById<ImageButton>(R.id.imgBtnObjetos);
        imgBoton8.setOnClickListener{
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 9)
            startActivity(intent)
        }
        imgBoton9.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 10)
            startActivity(intent)
        }
        imgBoton10.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 11)
            startActivity(intent)
        }
        imgBoton11.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 12)
            startActivity(intent)
        }
        imgBoton12.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 13)
            startActivity(intent)
        }
        imgBoton13.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 14)
            startActivity(intent)
        }
        imgBoton14.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 15)
            startActivity(intent)
        }
        imgBoton15.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 16)
            startActivity(intent)
        }

        return rootView

    }
}