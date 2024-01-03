package com.example.aymarswi.Herramientas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.Herramientas.Diccionario
import com.example.aymarswi.R

class DiccionarioAdapter(private var listaPalabras: List<Diccionario>,
                         private val onClickListener:(Diccionario) -> Unit,
                         private val onClickDelete:(Int) -> Unit
) : RecyclerView.Adapter<DiccionarioViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiccionarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DiccionarioViewHolder(layoutInflater.inflate(R.layout.item_diccionario, parent, false))
    }

    override fun getItemCount(): Int = listaPalabras.size

    override fun onBindViewHolder(holder: DiccionarioViewHolder, position: Int) {
        val item = listaPalabras[position]
        holder.render(item,onClickListener, onClickDelete)
    }
    fun actualizarDiccionario(listaPalabras: List<Diccionario>){
        this.listaPalabras = listaPalabras
        notifyDataSetChanged()
    }
}