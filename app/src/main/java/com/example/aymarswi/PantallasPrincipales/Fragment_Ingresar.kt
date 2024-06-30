package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.aymarswi.ApiRest.User
import com.example.aymarswi.PantallasPrincipales.FragmentSeleccionarIdioma.Companion.Idioma
import com.example.aymarswi.R
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Fragment_Ingresar : Fragment() {

    private lateinit var db: FirebaseFirestore
    private lateinit var user: User
    private lateinit var btnIngresar: Button
    private lateinit var btnRegistrar: TextView
    private lateinit var correo: EditText
    private lateinit var contr: EditText
    private lateinit var txtMensaje: TextView
    private lateinit var iBtnGoogle: ImageButton
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment__ingresar, container, false)
        initComponents()
        setup(btnIngresar, correo, contr)

        btnRegistrar.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 100)
            startActivity(intent)
        }

        iBtnGoogle.setOnClickListener {
            // Autenticación con Google
        }

        // Login con Facebook
        val iBtnFacebook = rootView.findViewById<ImageButton>(R.id.ibtnfacebook)

        return rootView
    }

    private fun initComponents() {
        btnIngresar = rootView.findViewById(R.id.btnIngresar)
        btnRegistrar = rootView.findViewById(R.id.txtBtnRegistro)
        correo = rootView.findViewById(R.id.idEmail)
        contr = rootView.findViewById(R.id.idPass)
        txtMensaje = rootView.findViewById(R.id.txtMensaje)
        iBtnGoogle = rootView.findViewById(R.id.iBtnGoogle)
    }



    private fun setup(
        btnIngresar: Button,
        correo: EditText,
        contr: EditText
    ) {
        btnIngresar.setOnClickListener {
            if (correo.text.isNotEmpty() && contr.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    correo.text.toString(),
                    contr.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(requireContext(), MenuEleccion::class.java))
                        Toast.makeText(requireContext(), "BIENVENIDO", Toast.LENGTH_SHORT).show()
                        getDataUserFromFirestoreDatabase(correo.text.toString())
                        savePreferencesUser(user)
                    } else {
                        mostrarError()
                    }
                }
            } else {
                if (correo.text.isEmpty()) correo.error = "Completa este campo"
                else if (contr.text.isEmpty()) contr.error = "Completa este campo"
            }
        }
    }

    private fun savePreferencesUser(user: User) {
        SharedPreferencesUsers.updatePreferences(requireContext(), user)
    }

    private fun getDataUserFromFirestoreDatabase(correo: String): User {
        db.collection("usuarios").document(correo).get().addOnSuccessListener {
            user.name = it.get("name") as String
            user.estrellas = it.get("estrellas") as Long
            user.imageProfileC = it.get("imageProfileC") as String
            user.imageProfileR = it.get("imageProfileR") as String
            user.level = it.get("level") as String
            user.medallasDoradas = it.get("medallasDoradas") as Long
            user.medallasPlateadas = it.get("medallasPlateadas") as Long
            user.trofeos = it.get("trofeos") as Long
        }
        return user
    }

    private fun mostrarError() {
        val btnRegistrar = requireView().findViewById<TextView>(R.id.txtBtnRegistro)
        val txtMensaje = requireView().findViewById<TextView>(R.id.txtMensaje)
        val colorOriginal = btnRegistrar.currentTextColor
        val tipoLetra = btnRegistrar.typeface
        txtMensaje.text = "Aun no estas registrado"
        btnRegistrar.setTextColor(Color.parseColor("#FF009688"))
        btnRegistrar.setTypeface(null, Typeface.BOLD)
        Handler().postDelayed({
            btnRegistrar.setTextColor(colorOriginal)
            btnRegistrar.setTypeface(tipoLetra)
        }, 3000)
    }
}