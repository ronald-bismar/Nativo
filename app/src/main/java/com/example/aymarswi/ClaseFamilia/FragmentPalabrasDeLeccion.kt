package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentPalabrasDeLeccion : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var btnEmpezarLecciones: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_palabrasdelecciones, container, false)

        viewPager = view.findViewById(R.id.viewPager)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguiente2)
        val btnIrALeccion = view.findViewById<Button>(R.id.btnIrALaLeccion)

        btnIrALeccion.setOnClickListener {
            Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.contenedorDeFragments, FragmentFamilia1())
        }

        // Crear el adaptador personalizado para el ViewPager
        val pagerAdapter = LeccionesPagerAdapter(childFragmentManager)
        viewPager.adapter = pagerAdapter

        btnSiguiente.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < pagerAdapter.count - 1) {
                viewPager.currentItem = currentItem + 1
            }
        }

        return view
    }

    // Clase adaptador personalizado para el ViewPager
    private inner class LeccionesPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {

        private val NUM_PAGES = 10 // Número total de páginas

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> FragmentPalabra1() // Reemplaza con tu fragmento personalizado o infla tu layout
                1 -> FragmentPalabra2() // Reemplaza con tu fragmento personalizado o infla tu layout
                2 -> FragmentPalabra3() // Reemplaza con tu fragmento personalizado o infla tu layout
                3 -> FragmentPalabra4() // Reemplaza con tu fragmento personalizado o infla tu layout
                4 -> FragmentPalabra5() // Reemplaza con tu fragmento personalizado o infla tu layout
                5 -> FragmentPalabra6() // Reemplaza con tu fragmento personalizado o infla tu layout
                6 -> FragmentPalabra7() // Reemplaza con tu fragmento personalizado o infla tu layout
                7 -> FragmentPalabra8() // Reemplaza con tu fragmento personalizado o infla tu layout
                8 -> FragmentPalabra9() // Reemplaza con tu fragmento personalizado o infla tu layout
                9 -> FragmentPalabra10() // Reemplaza con tu fragmento personalizado o infla tu layout
                // Agrega más casos para cada una de las páginas que deseas mostrar
                else -> FragmentPalabra1() // Reemplaza con tu fragmento personalizado o infla tu layout
            }
        }

        override fun getCount(): Int {
            return NUM_PAGES
        }
    }
}