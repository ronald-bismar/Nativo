package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.aymarswi.Avatars.FragmentA1
import com.example.aymarswi.PagerAdapter.MyPagerAdapter
import com.example.aymarswi.R
import com.example.aymarswi.model.TransactionFragment
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers
import com.google.firebase.firestore.FirebaseFirestore

class FragmentSeleccionarPersonaje : Fragment() {
    private lateinit var btnAnterior: Button
    private lateinit var btnSiguiente: Button
    private lateinit var viewPager: ViewPager
    private var imagenGuardadaId: Int =
        R.mipmap.iconousuariopordefecto // Valor predeterminado o imagen por defecto

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var db = FirebaseFirestore.getInstance()
        val rootView: View = inflater.inflate(R.layout.fragment_avatar2, container, false)

        btnAnterior = rootView.findViewById(R.id.btnIzquierda)
        btnSiguiente = rootView.findViewById(R.id.btnDerecha)
        viewPager = rootView.findViewById(R.id.contAvatar)
        viewPager.adapter = MyPagerAdapter(childFragmentManager)

        var idImagen = 0
        var idImagenRectangular = 0
        var nombrePersonaje = ""
        val btnAvatar = rootView.findViewById<Button>(R.id.btnAvatar)

        //Ir a la siguiente vista
        val fragment = FragmentA1()
        val transaccion: FragmentTransaction = requireActivity().supportFragmentManager
            .beginTransaction().replace(R.id.contAvatar, fragment)
        transaccion.commit()
        btnAnterior.setOnClickListener { viewPager.currentItem = viewPager.currentItem - 1 }
        btnSiguiente.setOnClickListener { viewPager.currentItem = viewPager.currentItem + 1 }
        btnAvatar.setOnClickListener {
            when (viewPager.currentItem) {
                0 -> {
                    idImagen = R.drawable.allqur
                    idImagenRectangular = R.mipmap.allqu_modified
                    nombrePersonaje = "Allqu"
                }

                1 -> {
                    idImagen = R.drawable.illarir
                    idImagenRectangular = R.mipmap.illari_modified
                    nombrePersonaje = "Illari"
                }

                2 -> {
                    idImagen = R.drawable.intir
                    idImagenRectangular = R.mipmap.inti_modified
                    nombrePersonaje = "Inti"
                }

                3 -> {
                    idImagen = R.drawable.jasyr
                    idImagenRectangular = R.mipmap.jasy_modified
                    nombrePersonaje = "Jasyr"
                }

                4 -> {
                    idImagen = R.drawable.killar
                    idImagenRectangular = R.drawable.killac
                    nombrePersonaje = "Killa"
                }

                5 -> {
                    idImagen = R.drawable.krausr
                    idImagenRectangular = R.mipmap.kraus_modified
                    nombrePersonaje = "Kraus"
                }

                6 -> {
                    idImagen = R.drawable.makir
                    idImagenRectangular = R.mipmap.maki_modified
                    nombrePersonaje = "Maki"
                }

                7 -> {
                    idImagen = R.drawable.munayr
                    idImagenRectangular = R.mipmap.munay_modified
                    nombrePersonaje = "Munay"
                }

                8 -> {
                    idImagen = R.drawable.qoriankar
                    idImagenRectangular = R.mipmap.qorianka_modified
                    nombrePersonaje = "Qorianka"
                }

                9 -> {
                    idImagen = R.drawable.waytar
                    idImagenRectangular = R.mipmap.wayta_modified
                    nombrePersonaje = "Wayta"
                }

                10 -> {
                    idImagen = R.drawable.wilar
                    idImagenRectangular = R.mipmap.wila_modified
                    nombrePersonaje = "Wila"
                }
            }
            SharedPreferencesUsers.updateOneDataOfPreferences(requireContext(), "imageProfileRound", idImagen.toString())
            SharedPreferencesUsers.updateOneDataOfPreferences(requireContext(), "imageProfileSquare", idImagenRectangular.toString())
            SharedPreferencesUsers.updateOneDataOfPreferences(requireContext(), "nombre", nombrePersonaje)

            Log.d("Imagenes", "Id: ${ SharedPreferencesUsers.getProfileOfPreferences(requireContext()) }")
            /*Log.d("Imagenes", "Id: ${ SharedPreferencesUsers.getOneData(requireContext(), "imageProfileRound", 0) }")
            Log.d("Imagenes", "Id: ${ SharedPreferencesUsers.getOneData(requireContext(), "imageProfileSquare", 0) }")*/

            /*db.collection("usuarios").document(correo.toString()).update(
                hashMapOf("Imagen de personaje" to idImagen) as Map<String, Any>
            )*/

            TransactionFragment.changeFragment(requireActivity() as AppCompatActivity, FragmentSeleccionarIdioma(), R.id.ContenedorP_Principales)
        }

        return rootView
    }
}