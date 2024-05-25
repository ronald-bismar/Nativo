package com.example.aymarswi.model.profileUser

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseData {

    fun logOutAccount(){
        FirebaseAuth.getInstance().signOut()
    }
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