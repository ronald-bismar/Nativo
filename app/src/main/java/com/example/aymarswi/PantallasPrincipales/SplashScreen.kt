package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.aymarswi.R

class SplashScreen : AppCompatActivity() {
    override fun finish() {
        super.finish()
        overridePendingTransition(0, 0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
            val correo = prefs.getString("correo", null)

            if (correo != null) {
                val intent = Intent(this, MenuEleccion::class.java)
                startActivity(intent)
            }
            else
            {
                val intent = Intent(this, ContenedorPantallasPrincipales::class.java)
                intent.putExtra("valor", 1)
                startActivity(intent)
            }
            finish()
        }, 1)
    }
}