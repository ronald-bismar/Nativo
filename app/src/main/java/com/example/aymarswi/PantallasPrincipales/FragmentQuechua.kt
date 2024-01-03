package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.aymarswi.R

class FragmentQuechua : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_quechua, container, false)

        val btnEmpezar = rootView.findViewById<Button>(R.id.empezar)

        btnEmpezar.setOnClickListener {

            val intent = Intent(requireContext(), MenuEleccionQ::class.java)
            startActivity(intent)

        }

        return rootView
    }
}