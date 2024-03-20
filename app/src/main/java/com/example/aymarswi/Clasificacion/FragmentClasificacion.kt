package com.example.aymarswi.Clasificacion

import UsuarioAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.R
import com.example.aymarswi.util.Datos
import com.example.aymarswi.databinding.FragmentClasificacionBinding
import com.google.firebase.firestore.FirebaseFirestore

class FragmentClasificacion : Fragment() {
    private lateinit var binding: FragmentClasificacionBinding
    private var listaUsuarios: MutableList<Usuario> = mutableListOf()
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClasificacionBinding.inflate(inflater, container, false)
        establecerAdaptador()

        return binding.root
    }

    private fun establecerAdaptador() {
        recycler = binding.recyclerUsuario
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = UsuarioAdapter(requireContext(), listaUsuarios)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = FirebaseFirestore.getInstance()
        val usuariosRef = db.collection("registros")
        var cont = 0

        usuariosRef.get().addOnSuccessListener { snapshot ->
            if (snapshot != null) {
                val nuevosUsuarios: MutableList<Usuario> = mutableListOf()

                for (document in snapshot.documents) {
                    // Obtener los datos del documento
                    val nombre = document.getString("nombre").toString() ?: ""
                    val puntuacion = document.getLong("puntuacion")?.toInt() ?: 0
                    val nivel = document.getString("nivel").toString() ?: ""
                    val imagenPersonaje =
                        document.getLong("Imagen de personaje")?.toInt() ?: R.mipmap.iconousuariopordefecto
                    val estrellas = document.getLong("estrellas")?: 0
                    val medallasDoradas = document.getLong("medallas doradas")?: 0
                    val trofeos = document.getLong("trofeos")?: 0
                    val medallasPlateadas = document.getLong("medallas plateadas")?: 0
                    val iconos:Int = Datos().determinarNivel(estrellas.toInt(), trofeos.toInt(), medallasDoradas.toInt(), medallasPlateadas.toInt())
                    nuevosUsuarios.add(Usuario(imagenPersonaje, nombre, nivel, puntuacion, iconos))
                }

                // Agregar los nuevos usuarios a la lista existente
                listaUsuarios.addAll(nuevosUsuarios)

                // Ordenar los usuarios según su puntuación (de mayor a menor)
                listaUsuarios.sortByDescending { it.puntaje}

                // Notificar al adaptador del RecyclerView que los datos han cambiado
                recycler.adapter?.notifyItemRangeInserted(cont, nuevosUsuarios.size)
                cont += nuevosUsuarios.size
            }
        }
    }
}