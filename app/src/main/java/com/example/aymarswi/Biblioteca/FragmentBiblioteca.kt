package com.example.aymarswi.Biblioteca

import BibliotecaAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.R
import com.example.aymarswi.databinding.FragmentBibliotecaBinding

class FragmentBiblioteca : Fragment() {
    private lateinit var binding: FragmentBibliotecaBinding
    private var listaLibros: MutableList<Libro> = mutableListOf()
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBibliotecaBinding.inflate(inflater, container, false)
        establecerAdaptador()

        return binding.root
    }

    private fun establecerAdaptador() {
        recycler = binding.recyclerBiblioteca
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = BibliotecaAdapter(requireContext(), listaLibros)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaLibros.add(
            Libro(
                "Aymara Aruskipawinaka",
                "Román Pairumani Ajacopa\nAlejandra Bertha Carrasco Lima",
                "2022",
                R.drawable.libroportada
            )
        )
        listaLibros.add(
            Libro(
                "Conociendo la cultura Aymara",
                "\nAlejandra Bertha Carrasco Lima",
                "1990",
                R.drawable.panka
            )
        )
        listaLibros.add(
            Libro(
                "Aymara Aruskipawinaka",
                "Román Pairumani Ajacopa\nAlejandra Bertha Carrasco Lima",
                "2000",
                R.drawable.libroportada
            )
        )
        listaLibros.add(
            Libro(
                "Aymara Aruskipawinaka",
                "Román Pairumani Ajacopa\nAlejandra Bertha Carrasco Lima",
                "2010",
                R.drawable.libroportada
            )
        )
        listaLibros.add(
            Libro(
                "Aymara Aruskipawinaka",
                "Román Pairumani Ajacopa\nAlejandra Bertha Carrasco Lima",
                "2006",
                R.drawable.libroportada
            )
        )
    }
}