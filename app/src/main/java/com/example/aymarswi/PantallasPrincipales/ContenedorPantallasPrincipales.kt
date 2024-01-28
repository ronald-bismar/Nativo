package com.example.aymarswi.PantallasPrincipales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.aymarswi.ClaseFamilia.PalabrasDeLaLeccion
import com.example.aymarswi.FragmentsGuias.FragmentGuiaBiblioteca
import com.example.aymarswi.FragmentsGuias.FragmentGuiaConversacion
import com.example.aymarswi.FragmentsGuias.FragmentGuiaDiccionario
import com.example.aymarswi.FragmentsGuias.FragmentGuiaLecciones
import com.example.aymarswi.R

class ContenedorPantallasPrincipales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor_pantallas_principales)

        when (intent.extras?.getInt("valor")) {
            1 -> {
                supportFragmentManager.commit {
                    add<FragmentPrimeraPantalla>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }

            10 -> {
                supportFragmentManager.commit {
                    add<FragmentGaleriaDeTrofeos>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }

            11 -> {
                supportFragmentManager.commit {
                    add<FragmentPrimeraPantalla>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }

            20->{
                supportFragmentManager.commit {
                    add<FragmentConfiguracion>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            30-> {
                supportFragmentManager.commit {
                    val fragment = FragmentMenuDeLeccionesA()
                    add(R.id.ContenedorP_Principales, fragment)
                    setReorderingAllowed(true)
                }
            }
            31-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaDiccionario>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            32-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaConversacion>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            33-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaBiblioteca>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            40-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaLecciones>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            41-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaDiccionario>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            42-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaConversacion>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
            43-> {
                supportFragmentManager.commit {
                    add<FragmentGuiaBiblioteca>(R.id.ContenedorP_Principales)
                    setReorderingAllowed(true)
                }
            }
        }
    }
}