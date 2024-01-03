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

class FragmentRegular : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val puntaje = requireArguments().getInt("valorp")
        val mp = MediaPlayer.create(requireContext(), R.raw.sonidosuccessytrompeta)
        mp.start()
        val rootView: View = inflater.inflate(R.layout.fragment_regular, container, false)
        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardatoR1)
        mPuntaje.text = "$puntaje/10"
        val gifImageView = rootView.findViewById<GifImageView>(R.id.gifMedalla)
        val gifDrawable = GifDrawable(resources, R.drawable.medalladorada)
        gifDrawable.loopCount = 1
        gifImageView.setImageDrawable(gifDrawable)

        Datos().actualizarPuntaje(requireContext(), puntaje, getString(R.string.prefs_file))

        val db = FirebaseFirestore.getInstance()
        val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val correo = prefs.getString("correo", null)

        db.collection("usuarios").document(correo.toString()).get().addOnSuccessListener { documentSnapshot ->
            val medallasDoradas = documentSnapshot.getLong("medallas doradas") ?: 0

            db.collection("usuarios").document(correo.toString()).update("medallas doradas", medallasDoradas+1)
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