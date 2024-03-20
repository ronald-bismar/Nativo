package com.example.aymarswi.NuevosArchivos.PerfilEmergente

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aymarswi.R
import com.google.firebase.firestore.FirebaseFirestore

class FragmentoPersonaje : Fragment() {
    private var imagenGuardadaId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragmento_personaje, container, false)
        val imagenDrawer = rootView.findViewById<ImageView>(R.id.imgPersonaje1)

        val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val idImagen = prefs.getInt("idImagenCirculo",0)
        imagenDrawer.setImageResource(idImagen)

        return rootView
    }
}
