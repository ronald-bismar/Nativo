package com.example.aymarswi.Herramientas.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aymarswi.Herramientas.Diccionario
import com.example.aymarswi.databinding.ItemDiccionarioBinding

class DiccionarioViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemDiccionarioBinding.bind(view)

    fun render(
        diccionarioModel: Diccionario,
        onClickListener: (Diccionario) -> Unit,
        onClickDelete: (Int) -> Unit
    ){
        binding.palAymara.text = diccionarioModel.palabraAym
        binding.palSignificado.text = diccionarioModel.significado
        Glide.with(binding.imagenPalabra.context).load(diccionarioModel.imagen).into(binding.imagenPalabra)
        itemView.setOnClickListener{onClickListener(diccionarioModel)}
        binding.btnDelete.setOnClickListener { onClickDelete(adapterPosition) }
    }
}