package com.example.aymarswi.PantallasPrincipales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.aymarswi.FragmentsGuias.FragmentGuiaBiblioteca
import com.example.aymarswi.FragmentsGuias.FragmentGuiaConversacion
import com.example.aymarswi.FragmentsGuias.FragmentGuiaDiccionario
import com.example.aymarswi.FragmentsGuias.FragmentGuiaLecciones
import com.example.aymarswi.R

class ContenedorPantallasPrincipales : AppCompatActivity() {
    private lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor_pantallas_principales)

        fragment = when (intent.extras?.getInt("valor")) {
            1 -> FragmentPrimeraPantalla()
            10 -> FragmentGaleriaDeTrofeos()
            11 -> FragmentPrimeraPantalla()
            20 -> FragmentConfiguracion()
            30 -> FragmentMenuDeLeccionesA()
            31 -> FragmentGuiaDiccionario()
            32 -> FragmentGuiaConversacion()
            33 -> FragmentGuiaBiblioteca()
            40 -> FragmentMenuDeLeccionesQ()
            41 -> FragmentGuiaDiccionario()
            42 -> FragmentGuiaConversacion()
            43 -> FragmentGuiaBiblioteca()
            else -> FragmentPrimeraPantalla()
        }

        supportFragmentManager.commit {
            add(R.id.ContenedorP_Principales, fragment)
            setReorderingAllowed(true)
        }
    }
}