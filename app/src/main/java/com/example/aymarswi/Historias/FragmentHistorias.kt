package com.example.aymarswi.Historias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.Biblioteca.Libro
import com.example.aymarswi.R
import com.example.aymarswi.databinding.FragmentBibliotecaBinding
import com.example.aymarswi.databinding.FragmentHistoriasBinding

class FragmentHistorias : Fragment() {
    private lateinit var binding: FragmentHistoriasBinding
    private var listaHistorias: MutableList<Historia> = mutableListOf()
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoriasBinding.inflate(inflater, container, false)
        establecerAdaptador()

        return binding.root
    }

    private fun establecerAdaptador() {
        recycler = binding.recyclerHistoria
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = HistoriaAdapter(requireContext(), listaHistorias, requireFragmentManager())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaHistorias.add(Historia(R.drawable.tupakkatari, "Tupak Katari", "Historia"))
        listaHistorias.add(Historia(R.drawable.imagenmontana, "Inas Ukhamächi", "Relatos"))
        listaHistorias.add(Historia(R.drawable.tupakkatari, "Tupak Katari", "Historia"))
        listaHistorias.add(Historia(R.drawable.imagenmontana, "Inas Ukhamächi", "Relatos"))
        listaHistorias.add(Historia(R.drawable.tupakkatari, "Tupak Katari", "Historia"))
        listaHistorias.add(Historia(R.drawable.imagenmontana, "Inas Ukhamächi", "Relatos"))
        listaHistorias.add(Historia(R.drawable.tupakkatari, "Tupak Katari", "Historia"))
        listaHistorias.add(Historia(R.drawable.imagenmontana, "Inas Ukhamächi", "Relatos"))
    }
}
