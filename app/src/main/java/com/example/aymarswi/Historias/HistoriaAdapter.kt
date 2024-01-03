package com.example.aymarswi.Historias
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.R

class HistoriaAdapter(
    private val context: Context,
    private val listaHistorias: MutableList<Historia>,
    private val fragmentManager: FragmentManager // Agrega el FragmentManager al constructor
) : RecyclerView.Adapter<HistoriaAdapter.MiHolder>() {

    inner class MiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imagenHistoria: ImageView
        lateinit var tituloHistoria: TextView
        lateinit var categoriaHistoria: TextView

        init {
            imagenHistoria = itemView.findViewById(R.id.imgHistoria)
            tituloHistoria = itemView.findViewById(R.id.txtTituloHistoria)
            categoriaHistoria = itemView.findViewById(R.id.txtBiografia)

            itemView.setOnClickListener {
                val historia = listaHistorias[adapterPosition]
                val fragment = FragmentHistoriaPaginas() // Suponiendo que tienes un ID para identificar la historia
                fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView3, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.cardview_historias, parent, false)
        return MiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaHistorias.size
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        val historia = listaHistorias[position]
        holder.imagenHistoria.setImageResource(historia.imagenPortada)
        holder.tituloHistoria.text = historia.titulo
        holder.categoriaHistoria.text = historia.categoria
    }
}