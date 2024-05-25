package com.example.aymarswi.PantallasPrincipales

import UIProfileUsers
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers
import com.example.aymarswi.view.MenuDrawer

class MenuEleccion : AppCompatActivity() {

    private lateinit var btnHistorias: Button
    private lateinit var btnLecciones: Button
    private lateinit var btnDiccionario: Button
    private lateinit var btnChat: Button
    private lateinit var imgProfile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_eleccion)

        initComponents()
        MenuDrawer(this)
        setOnClickButtons()
        setMainImageProfile()
    }

    private fun setMainImageProfile() {
        imgProfile.setImageResource(
            SharedPreferencesUsers.getPreferencesUser(this).getString("imageProfileRound", "")?.toInt() ?: 0
        )
        imgProfile.setOnClickListener {
            UIProfileUsers(this).showAlertDialogProfileUser(this)
        }
    }

    private fun setOnClickButtons() {
        btnHistorias.setOnClickListener { startNewActivity<ActivityContenedor>(99) }
        btnLecciones.setOnClickListener { startNewActivity<ContenedorPantallasPrincipales>(30) }
        btnDiccionario.setOnClickListener { startNewActivity<ContenedorPantallasPrincipales>(31) }
        btnChat.setOnClickListener { startNewActivity<ContenedorPantallasPrincipales>(32) }
    }

    private inline fun <reified T : AppCompatActivity> startNewActivity(value: Int) {
        val intent = Intent(this, T::class.java)
        intent.putExtra("valor", value)
        startActivity(intent)
    }

    private fun initComponents() {
        btnHistorias = findViewById(R.id.btnHistorias)
        btnLecciones = findViewById(R.id.btnLecciones)
        btnDiccionario = findViewById(R.id.btnDiccionario)
        btnChat = findViewById(R.id.btnChat)
        imgProfile = findViewById(R.id.imgPersonaje)
    }
}