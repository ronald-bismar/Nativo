package com.example.prueba


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.R

class RecyclerNombre(
    private val context: Context,
    private val listaDeMensajes: MutableList<Mensaje>
) : RecyclerView.Adapter<RecyclerNombre.MiHolder>() {

    inner class MiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var labelMensaje: TextView

        init {
            labelMensaje = itemView.findViewById(R.id.labelMensaje)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        val itemView = when (viewType) {
            0 -> LayoutInflater.from(context).inflate(R.layout.cartapersonaje, parent, false)
            else -> LayoutInflater.from(context).inflate(R.layout.cartausuario, parent, false)
        }
        return MiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaDeMensajes.size
    }

    override fun getItemViewType(position: Int): Int {
        // Determina el tipo de vista según la posición en la lista
        return position % 2
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        val mensaje = listaDeMensajes[position]
        holder.labelMensaje.text = mensaje.mensaje
    }
}