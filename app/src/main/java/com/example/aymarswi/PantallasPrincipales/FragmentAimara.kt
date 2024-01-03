package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.aymarswi.R
class FragmentAimara : Fragment() {
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_aimara, container, false)
           val btnEmpezar = rootView.findViewById<Button>(R.id.empezar)

           btnEmpezar.setOnClickListener {

               val intent = Intent(requireContext(), MenuEleccion::class.java)
               startActivity(intent)

           }

           return rootView
    }
}