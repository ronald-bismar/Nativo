package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.ApiRest.RetrofitCliente
import com.example.aymarswi.ApiRest.Usuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FragmentRegistro : Fragment() {

    /*val principiante = "Principiante"
     val elemental = "Elemental"
     val intermedio = "Intermedio"
     val intermedioAlto = "Intermedio Alto"
     val avanzado = "Avanzado"
     val competente = "Competente"*/
    var usuario = Usuario(-1, "", "", "")
    private lateinit var nombreUsuario: EditText
    private lateinit var correoUsuario: EditText
    private lateinit var contrUsuario: EditText
    private lateinit var confContrUsuario: EditText
    private lateinit var btnRegistro: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_registro, container, false)
        nombreUsuario = rootView.findViewById(R.id.etNombre)
        correoUsuario = rootView.findViewById(R.id.et_correo)
        contrUsuario = rootView.findViewById(R.id.et_contrasena)
        confContrUsuario = rootView.findViewById(R.id.etConfContraseña)
        btnRegistro = rootView.findViewById(R.id.btnRegistrarse)

        btnRegistro.setOnClickListener {
            if (verificarCampos()) {
                CoroutineScope(Dispatchers.Main).launch {
                    if (!verificarCorreoExistente() && agregarUsuario() && agregarUsuarioFireBase()) {
                        guardarPreferencias()
                        limpiarCampos()
                        limpiarObjeto()
                        elegirPersonaje()
                    }
                }
            }
        }

        return rootView
    }

    private fun verificarCampos(): Boolean {
        val regex = Regex("[\\w\\-\\.]+@[\\w\\-]+\\.[\\w]+")
        var confirmacion = true
        if (nombreUsuario.text.isEmpty() || correoUsuario.text.isEmpty() || contrUsuario.text.isEmpty()
            || confContrUsuario.text.isEmpty()
        ) {
            if (nombreUsuario.text.isEmpty()) nombreUsuario.error = "Completa este campo"
            else if (correoUsuario.text.isEmpty()) correoUsuario.error = "Completa este campo"
            else if (contrUsuario.text.isEmpty()) contrUsuario.error = "Completa este campo"
            else if (confContrUsuario.text.isEmpty()) confContrUsuario.error = "Completa este campo"
            confirmacion = false
        } else if (!regex.matches(correoUsuario.text.toString())) {
            Toast.makeText(requireContext(), "Correo electronico no valido", Toast.LENGTH_SHORT)
                .show()
        } else if (contrUsuario.text.toString() != (confContrUsuario.text.toString())) {
            Toast.makeText(
                requireContext(),
                "La confirmacion de contraseña no coincide",
                Toast.LENGTH_SHORT
            ).show()
            confirmacion = false
        }

        return confirmacion
    }

    private suspend fun verificarCorreoExistente(): Boolean {
        return suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.IO).launch {
                val response = RetrofitCliente.servicioWeb.verificarCorreoExistente(correoUsuario.text.toString())
                CoroutineScope(Dispatchers.Main).launch {
                    if (response.isSuccessful) {
                        val correoExiste = response.body() ?: true
                        if(correoExiste)
                            Toast.makeText(requireContext(), "El correo electronico ya existe", Toast.LENGTH_SHORT).show()
                        continuation.resume(correoExiste)
                    } else {
                        // Manejar el error de la solicitud Retrofit aquí
                        Toast.makeText(requireContext(), "Error al verificar el correo", Toast.LENGTH_SHORT).show()
                        continuation.resume(false)
                    }
                }
            }
        }
    }


    private suspend fun agregarUsuarioFireBase(): Boolean {
        return suspendCoroutine { continuation ->
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                correoUsuario.text.toString(), contrUsuario.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "Confirmacion FireBase exitosa",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    continuation.resume(true)
                } else {
                    continuation.resume(false)
                }
            }
        }
    }

    private suspend fun agregarUsuario(): Boolean {
        return suspendCoroutine { continuation ->
            this.usuario.nombre = nombreUsuario.text.toString()
            this.usuario.correo = correoUsuario.text.toString()
            this.usuario.contrasena = contrUsuario.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                val call = RetrofitCliente.servicioWeb.agregarUsuario(usuario)
                CoroutineScope(Dispatchers.Main).launch {
                    if (call.isSuccessful) {
                        continuation.resume(true)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Fallo en la conexion SQL",
                            Toast.LENGTH_SHORT
                        ).show()
                        continuation.resume(false)
                    }
                }
            }
        }
    }

    private fun guardarPreferencias() {
        val prefs = requireContext().getSharedPreferences(
            getString(R.string.prefs_file),
            Context.MODE_PRIVATE
        ).edit()
        prefs.putString("nombre", nombreUsuario.text.toString())
        prefs.putString("correo", correoUsuario.text.toString())
        prefs.putString("contraseña", contrUsuario.text.toString())
        prefs.apply()
    }

    private fun elegirPersonaje() {
        /*Utils().pasarDeFragment(
            requireActivity() as AppCompatActivity,
            R.id.ContenedorP_Principales,
            FragmentAvatar2()
        )*/
    }

    private fun actualizarUsuario() {
        this.usuario.nombre = nombreUsuario.text.toString()
        this.usuario.correo = correoUsuario.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitCliente.servicioWeb.actualizarUsuario(usuario.idUsuario, usuario)
            CoroutineScope(Dispatchers.Main).launch {
                if (call.isSuccessful) {
                    Toast.makeText(requireContext(), call.body().toString(), Toast.LENGTH_SHORT)
                        .show()
                    limpiarCampos()
                    limpiarObjeto()
                } else {
                    Toast.makeText(requireContext(), call.body().toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun limpiarCampos() {
        nombreUsuario.setText("")
        correoUsuario.setText("")
        contrUsuario.setText("")
        confContrUsuario.setText("")
    }

    private fun limpiarObjeto() {
        this.usuario.idUsuario = -1
        this.usuario.nombre = ""
        this.usuario.correo = ""
        this.usuario.contrasena = ""
    }
}