package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ApiRest.User
import com.example.aymarswi.R
import com.example.aymarswi.model.TransactionFragment
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers
import com.google.firebase.firestore.FirebaseFirestore

class FragmentSeleccionarIdioma : Fragment() {
    private lateinit var rootView: View
    private lateinit var btnIAymara : Button
    private lateinit var btnIQuechua: Button
    private lateinit var user: User
    private lateinit var db: FirebaseFirestore

    companion object{
        lateinit var Idioma: String
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_seleccionar_idioma, container, false)
        initFirestore()
        initComponents()
        getUser()
        clickButtons()

        return rootView
    }

    private fun getUser() {
        user = SharedPreferencesUsers.getProfileOfPreferences(requireContext())
    }

    private fun initFirestore() {
        db = FirebaseFirestore.getInstance()
    }

    private fun changeFragmentLocal(fragment: Fragment) {
        TransactionFragment.changeFragment(requireActivity() as AppCompatActivity, fragment, R.id.ContenedorP_Principales)
    }

    private fun clickButtons() {
        btnIAymara.setOnClickListener {
            Idioma = "Aymara"
            changeFragmentLocal(FragmentAimara())
            saveUserToFirestoreDatabase()
        }

        btnIQuechua.setOnClickListener {
            Idioma = "Quechua"
            changeFragmentLocal(FragmentQuechua())
            saveUserToFirestoreDatabase()
        }

    }

    private fun saveUserToFirestoreDatabase() {
        db.collection("usuarios").document(user.email).set(
            hashMapOf(
                "name" to user.name,
                "email" to user.email,
                "level" to user.level,
                "imageProfileR" to user.imageProfileR,
                "imageProfileC" to user.imageProfileC,
                "estrellas" to user.estrellas,
                "trofeos" to user.trofeos,
                "medallasDoradas" to user.medallasDoradas,
                "medallasPlateadas" to user.medallasPlateadas,
            )
        )
    }

    private fun initComponents() {
        btnIAymara = rootView.findViewById(R.id.btnIAymara)
        btnIQuechua = rootView.findViewById(R.id.btnIQuechua)
    }
}