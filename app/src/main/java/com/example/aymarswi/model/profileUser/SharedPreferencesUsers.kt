package com.example.aymarswi.model.profileUser

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.aymarswi.ApiRest.User
import com.example.aymarswi.R

object SharedPreferencesUsers {
    fun getPreferencesUser(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.prefs_file),
            Context.MODE_PRIVATE
        )
    }

    fun updatePreferences(context: Context, user: User) {
        val prefs = initEditPreferences(context)
        prefs.putString("nombre", user.name)
        prefs.putString("correo", user.email)
        prefs.putString("contraseña", user.password)
        prefs.putString("level", user.level)
        prefs.putString("imageProfileRound", user.imageProfileR)
        prefs.putString("imageProfileSquare", user.imageProfileC)
        prefs.putString("estrellas", user.estrellas.toString())
        prefs.putString("trofeos", user.trofeos.toString())
        prefs.putString("medallasDoradas", user.medallasDoradas.toString())
        prefs.putString("medallasPlateadas", user.medallasPlateadas.toString())

        prefs.apply()
    }

    fun getProfileOfPreferences(context: Context): User {
        val prefs = getPreferencesUser(context)
        return User(
            -1,
            prefs.getString("nombre", null) ?: "",
            prefs.getString("correo", null) ?: "",
            prefs.getString("contraseña", null) ?: "",
            prefs.getString("level", null) ?: "",
            prefs.getString("imageProfileRound", null) ?: "",
            prefs.getString("imageProfileSquare", null) ?: "",
            prefs.getString("estrellas", null)!!.toLong(),
            prefs.getString("trofeos", null)!!.toLong(),
            prefs.getString("medallasDoradas", null)!!.toLong(),
            prefs.getString("medallasPlateadas", null)!!.toLong(),
        )
    }

    fun updateOneDataOfPreferences(context: Context, key: String, value: String) {
        val prefs = initEditPreferences(context)
        prefs.putString(key, value)
        prefs.apply()
    }

    fun getOneData(context: Context, key: String, value: Any): String? {
        val prefs = getPreferencesUser(context)
        return prefs.getString(key, value.toString())
    }

    private fun initEditPreferences(context: Context): SharedPreferences.Editor {
        return getPreferencesUser(context).edit()
    }
    fun clearPreferences(context: Context){
        val prefs = initEditPreferences(context)
        prefs.clear()
        prefs.apply()
    }
}