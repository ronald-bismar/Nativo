package com.example.aymarswi.PantallasPrincipales
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.aymarswi.NuevosArchivos.PerfilEmergente.FragmentoPersonaje
import com.example.aymarswi.R
import com.example.aymarswi.Util.Datos
import com.facebook.login.LoginManager
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MenuEleccion : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private var db = FirebaseFirestore.getInstance()
    private lateinit var correoGuardado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_eleccion)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombreusuario")
        val correoU = bundle?.getString("correousuario")
        val contr = bundle?.getString("contrusuario")

        Log.d("datos recibidos", "El nombre es $nombre")
        Log.d("datos recibidos", "El correo es $correoU")
        Log.d("datos recibidos", "La contraseña es $contr")


        val prefsR = getSharedPreferences(
            getString(R.string.prefs_file),
            Context.MODE_PRIVATE
        )

        val imgPersonajeR = prefsR.getInt("idImagenCirculo", 0)
        val imgPersonajeC = prefsR.getInt("idImagenRectangular", 0)
        val nomPersonaje = prefsR.getString("nombrePersonaje", null)?:""
        val imgPersonaje = findViewById<ImageView>(R.id.imgPersonaje)
        imgPersonaje.setImageResource(imgPersonajeR)

        //perfil historial (fragmento personaje invocado)

        // Obtén una referencia al FragmentManager
        val fragmentManager = supportFragmentManager

        // Obtén una referencia al Fragmento
        // Acceder a la ImageView en el fragmento
        val fragmentoPersonaje = FragmentoPersonaje()

// Acceder a la imagen del fragmento
        val iPersonaje = fragmentoPersonaje.view?.findViewById<ImageView>(R.id.imgPersonaje1)
        iPersonaje?.setImageResource(imgPersonajeR)

        //navigation drawer

        drawer = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val headerView: View = navigationView.getHeaderView(0)
        val imageView: ImageView = headerView.findViewById(R.id.nav_header_imageView)

        imageView.setImageResource(imgPersonajeC)

        // Boton Historias
        val btnHistorias = findViewById<Button>(R.id.btnHistorias)
        btnHistorias.setOnClickListener {
            val intent = Intent(this, ActivityContenedor::class.java)
            intent.putExtra("valor", 99)
            startActivity(intent)
        }

        val btnAbrirDrawer = findViewById<ImageView>(R.id.btnBurger)
        btnAbrirDrawer.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        // Datos recibidos desde el activity MainPrincipalActivity
        val datosEnviados = intent.extras
        val correo = datosEnviados?.getString("correousuario")

        // Recuperar imagen guardada de SharedPreferences
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        correoGuardado = prefs.getString("correo", null).toString()

        //Funciones de los botones de la pantalla principal



        val boton = findViewById<Button>(R.id.btnLecciones)
        funcionImagenPerfil(imgPersonaje, imgPersonajeR, nomPersonaje)
        boton.setOnClickListener {
            val intent: Intent = (Intent(this, ContenedorPantallasPrincipales::class.java))
            intent.putExtra("valor", 30)
            startActivity(intent)
        }
        val btnDiccionario = findViewById<Button>(R.id.btnDiccionario)
        btnDiccionario.setOnClickListener {
            val intent: Intent = (Intent(this, ContenedorPantallasPrincipales::class.java))
            intent.putExtra("valor", 31)
            startActivity(intent)
        }
        val btnChat = findViewById<Button>(R.id.btnChat)
        btnChat.setOnClickListener {
            val intent: Intent = (Intent(this, ContenedorPantallasPrincipales::class.java))
            intent.putExtra("valor", 32)
            startActivity(intent)
        }
    }

    fun funcionImagenPerfil(img: ImageView, idImagen: Int, nombre: String) {
        img.setOnClickListener {
            val view = View.inflate(this, R.layout.fragmento_personaje, null)
            val imagen = view.findViewById<ImageView>(R.id.imgPersonaje1)
            val pNombre = view.findViewById<TextView>(R.id.txtNombrePersonaje)
            val imagenIconos = view.findViewById<ImageView>(R.id.mObtenidas)
            val nivel = view.findViewById<TextView>(R.id.txtNivel)
            val estrellas = view.findViewById<TextView>(R.id.txtNivelEstrella)
            val trofeos = view.findViewById<TextView>(R.id.txtTrofeosObtenidos)
            val medallasDoradas = view.findViewById<TextView>(R.id.txtMedallasDoradas)
            val medallasPlateadas = view.findViewById<TextView>(R.id.txtMedallasPlateadas)

            imagen.setImageResource(idImagen)
            pNombre.text = nombre
            var idImagenIconos = 0
            var txtNivel = ""
            var txtEstrellas: Long
            var txtTrofeos: Long
            var txtMedallasDoradas: Long
            var txtMedallasPlateadas: Long
            db.collection("usuarios").document(correoGuardado).get().addOnSuccessListener { document ->
                txtNivel = document.get("nivel") as String ?: ""
                txtEstrellas = document.getLong("estrellas")?: 0
                txtTrofeos = document.getLong("trofeos")?: 0
                txtMedallasDoradas = document.getLong("medallas doradas")?: 0
                txtMedallasPlateadas = document.getLong("medallas plateadas")?: 0

                idImagenIconos = Datos().determinarNivel(txtEstrellas.toInt(), txtTrofeos.toInt(), txtMedallasDoradas.toInt(), txtMedallasPlateadas.toInt())
                imagenIconos.setImageResource(idImagenIconos)
                nivel.text = "Nivel: $txtNivel"
                estrellas.text = "Nivel estrella: $txtEstrellas estrellas"
                trofeos.text = "Trofeos obtenidos: $txtTrofeos trofeos"
                medallasDoradas.text = "Medallas doradas: $txtMedallasDoradas medallas"
                medallasPlateadas.text = "Medallas plateadas: $txtMedallasPlateadas medallas"

                val builder = AlertDialog.Builder(this)
                builder.setView(view)
                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.setCancelable(false)
                dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
                    dialog.dismiss()
                }
            }
        }
    }

    // Puedes acceder a la imagen del encabezado de navegación utilizando 'imageView'
// Por ejemplo, puedes cambiar la imagen con otra usando:
// imageView.setImageResource(R.drawable.otra_imagen)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemQuechua->{
                val intent = Intent(this, MenuEleccionQ::class.java)
                startActivity(intent)
            }
            R.id.itemRanking -> {
                val intent = Intent(this, ActivityContenedor::class.java)
                intent.putExtra("valor", 97)
                startActivity(intent)
            }
            R.id.nav_item_two -> {
                val intent = Intent(this, ContenedorPantallasPrincipales::class.java)
                intent.putExtra("valor", 10)
                startActivity(intent)
            }
            R.id.nav_item_three -> {
                val intent = Intent(this, ContenedorPantallasPrincipales::class.java)
                intent.putExtra("valor", 33)
                startActivity(intent)
            }
            R.id.nav_item_six -> {
                val intent = Intent(this, ContenedorPantallasPrincipales::class.java)
                intent.putExtra("valor", 20)
                startActivity(intent)
            }

            R.id.nav_item_seven -> {
                //Borrar datos al presionar el boton de salir de cuenta
                val prefs =
                    getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                prefs.clear()
                prefs.apply()
                //Logout desde Firebase
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, ContenedorPantallasPrincipales::class.java)
                intent.putExtra("valor", 11)
                startActivity(intent)
                val prefsFacebook =
                    getSharedPreferences(getString(R.string.prefFacebook_file), Context.MODE_PRIVATE).edit()
                if (prefsFacebook != null) {
                    LoginManager.getInstance().logOut()
                    prefsFacebook.clear()
                    prefsFacebook.apply()
                }
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}