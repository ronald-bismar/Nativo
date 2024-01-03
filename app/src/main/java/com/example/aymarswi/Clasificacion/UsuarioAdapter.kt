import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.Clasificacion.Usuario
import com.example.aymarswi.R
import com.example.prueba.RecyclerNombre
import java.net.URL

class UsuarioAdapter(
    private val context: Context,
    private val listaDeUsuarios: MutableList<Usuario>
) : RecyclerView.Adapter<UsuarioAdapter.MiHolder>() {

    inner class MiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imagenPerfil: ImageView
        lateinit var nombreUsuario: TextView
        lateinit var nivelUsuario: TextView
        lateinit var puntajeUsuario: TextView
        lateinit var imgViewIconos: ImageView

        init {
            imagenPerfil = itemView.findViewById(R.id.imgViewUsuario)
            nombreUsuario = itemView.findViewById(R.id.txtNombreUsuario)
            nivelUsuario = itemView.findViewById(R.id.nivelUsuario)
            puntajeUsuario = itemView.findViewById(R.id.puntajeUsuario)
            imgViewIconos = itemView.findViewById(R.id.imgViewIconos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.cardviewclasificacion, parent, false)
        return MiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaDeUsuarios.size
    }
    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        val usuario = listaDeUsuarios[position]
        holder.imagenPerfil.setImageResource(usuario.imagenPerfil)
        holder.nombreUsuario.text = usuario.nombreUsuario
        holder.nivelUsuario.text = usuario.nivel
        holder.puntajeUsuario.text = usuario.puntaje.toString()
        holder.imgViewIconos.setImageResource(usuario.imagenIconos)
        // Agrega aquí la lógica para mostrar los iconos en llIconos
    }
}