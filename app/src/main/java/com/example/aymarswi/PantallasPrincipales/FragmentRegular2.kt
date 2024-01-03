package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.Util.Datos
import com.google.firebase.firestore.FirebaseFirestore
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView
class FragmentRegular2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_regular2, container, false)
        val puntaje = requireArguments().getInt("valorp")
        //val btnMenu = rootView.findViewById<Button>(R.id.btnMenu)
        val mp = MediaPlayer.create(requireContext(), R.raw.sonidotrompeta)
        mp.start()
        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardatoR2)
        mPuntaje.text = "$puntaje/10"
        val gifImageView = rootView.findViewById<GifImageView>(R.id.gifMedallaP)
        val gifDrawable = GifDrawable(resources, R.drawable.medallaplateada)
        gifDrawable.loopCount = 1
        gifImageView.setImageDrawable(gifDrawable)

        Datos().actualizarPuntaje(requireContext(), puntaje, getString(R.string.prefs_file))

        val db = FirebaseFirestore.getInstance()
        val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val correo = prefs.getString("correo", null)

        db.collection("usuarios").document(correo.toString()).get().addOnSuccessListener { documentSnapshot ->
            val medallasPlateadas = documentSnapshot.getLong("medallas plateadas") ?: 0

            db.collection("usuarios").document(correo.toString()).update("medallas doradas", medallasPlateadas+1)
                .addOnSuccessListener {
                    Log.d("Actualizacion", "La puntuación se actualizó exitosamente")
                }
                .addOnFailureListener { e ->
                    Log.d("Actualizacion", "Error al actualizar la puntuación: ${e.message}")
                }
        }

        return rootView
    }
}