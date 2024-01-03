package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.aymarswi.R
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aymarswi.Herramientas.Diccionario
import com.example.aymarswi.Herramientas.DiccionarioProvider
import com.example.aymarswi.Herramientas.adapter.DiccionarioAdapter
import com.example.aymarswi.databinding.FragmentDiccionarioBinding
class FragmentDiccionario : Fragment() {

    private lateinit var binding: FragmentDiccionarioBinding
    private var listaPalabrasMutableList: MutableList<Diccionario> =
        DiccionarioProvider.listaPalabras.toMutableList()
    private lateinit var adapter: DiccionarioAdapter
    private lateinit var llmanager:LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDiccionarioBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llmanager = LinearLayoutManager(requireContext())

        binding.btnAgregarPalabra.setOnClickListener { crearDiccionario() }
        binding.edFilter.addTextChangedListener { userFilter ->
            val palabrasFiltradas = listaPalabrasMutableList.
            filter { diccionario -> diccionario.significado.lowercase().contains(userFilter.toString().lowercase()) }
            adapter.actualizarDiccionario(palabrasFiltradas)
        }
        iniciarRecyclerView()
    }

    private fun crearDiccionario() {
        val palabra = Diccionario(
            "Incognito", "Nosesabe", "https://amigosgrandesmaestros.org/wp-content/uploads/2019/04/GMIBOL-F9-A_2.jpg"
        )
        listaPalabrasMutableList.add(index = 3, palabra)
        adapter.notifyItemInserted(listaPalabrasMutableList.size - 1)
        llmanager.scrollToPositionWithOffset(3, 10)
    }

    private fun iniciarRecyclerView() {
        adapter = DiccionarioAdapter(
            listaPalabras = listaPalabrasMutableList,
            onClickListener = { diccionario -> itemSeleccionado(diccionario) },
            onClickDelete = { position -> onDeletedItem(position) }
        )
        binding.recyclerDiccionario.layoutManager = llmanager
        binding.recyclerDiccionario.adapter = adapter
    }

    private fun onDeletedItem(position: Int) {
        listaPalabrasMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
    private fun itemSeleccionado(diccionario: Diccionario) {
        Toast.makeText(requireContext(), diccionario.significado, Toast.LENGTH_SHORT).show()
    }
}