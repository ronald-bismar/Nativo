package com.example.aymarswi.model.profileUser

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class Profile {
    private lateinit var nivel: String
    private var estrellas: Long = 0
    private var trofeos: Long = 0
    private var medallasDoradas: Long = 0
    private var medallasPlateadas: Long = 0

    fun getDataUserFromFirebase(correoUsuario: String): DocumentSnapshot? {
        val instanceFirebase = getInstanceFirebase()
        return getDates(instanceFirebase, correoUsuario)
    }

    private fun getInstanceFirebase(): FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getDates(instanceFirebase: FirebaseFirestore, correoGuardado: String): DocumentSnapshot? {

        var datesUser: DocumentSnapshot? = null
        instanceFirebase.collection("usuarios").document(correoGuardado).get()
            .addOnSuccessListener { document ->
                datesUser = document
            }
        return datesUser
    }
}