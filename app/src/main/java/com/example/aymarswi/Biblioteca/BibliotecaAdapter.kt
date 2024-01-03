import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.Biblioteca.Libro
import com.example.aymarswi.Clasificacion.Usuario
import com.example.aymarswi.R
import com.example.prueba.RecyclerNombre
import java.net.URL

class BibliotecaAdapter(
    private val context: Context,
    private val listaDeLibros: MutableList<Libro>
) : RecyclerView.Adapter<BibliotecaAdapter.MiHolder>() {

    inner class MiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var titulo: TextView
        lateinit var autor: TextView
        lateinit var imagen: ImageView

        init {
            titulo = itemView.findViewById(R.id.tituloLibro)
            autor = itemView.findViewById(R.id.txtAutor)
            imagen = itemView.findViewById(R.id.imgLibro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.card_view_libro, parent, false)
        return MiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaDeLibros.size
    }
    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        val usuario = listaDeLibros[position]
        holder.imagen.setImageResource(usuario.imagen)
        holder.titulo.text = usuario.titulo
        holder.autor.text = usuario.autor
        // Agrega aquí la lógica para mostrar los iconos en llIconos
    }
}