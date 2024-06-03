package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.aymarswi.PantallasPrincipales.FragmentSeleccionarIdioma.Companion.Idioma
import com.example.aymarswi.R
import com.example.aymarswi.model.lecciones.Lecciones
import com.example.aymarswi.model.textoLecciones.LeccionesJSON
import com.example.aymarswi.util.Actividad
import com.example.aymarswi.util.Actividad.Companion.getInstanceActividad

class ActivityContenedor : AppCompatActivity() {
    private lateinit var fragment: Fragment
    private lateinit var nombreLeccion: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)
        Actividad.getInstance(this, this, R.id.contenedorDeFragments)

        nombreLeccion = when (intent.extras?.getInt("valor")) {
            1 -> "Familia"
            2 -> "Naturaleza"
            3 -> "Saludos"
            4 -> "Animales"
            5 -> "Verbos"
            6 -> "Colores"
            7 -> "Numeros"
            8 -> "Objetos"
            /*93 -> FragmentGuiaDiccionario()
            94 -> FragmentGuiaLecciones()
            95 -> FragmentGuiaBiblioteca()
            96 -> FragmentAvatar2()
            97 -> FragmentClasificacion()
            98 -> FragmentGuiaConversacion()
            99 -> FragmentGuiaHistorias()
            100 -> FragmentRegistro()*/
            else -> "Familia"
        }

        LeccionesJSON.seccion("${ nombreLeccion }_$Idioma")
        getInstanceActividad().rutaDeFragments = Lecciones().getLesson( nombreLeccion )

        fragment = getInstanceActividad().rutaDeFragments.first()
        supportFragmentManager.commit {
            add(R.id.contenedorDeFragments, fragment)
            setReorderingAllowed(true)
        }
    }
}