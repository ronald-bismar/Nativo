package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aymarswi.R
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class Fragment_Ingresar : Fragment() {

    private val GOOGLE_SIGN_IN = 100
//    private val callbackManager = CallbackManager.Factory.create()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:View =  inflater.inflate(R.layout.fragment__ingresar, container, false)

        val btnIngresar = rootView.findViewById<Button>(R.id.btnIngresar)
        val btnRegistrar = rootView.findViewById<TextView>(R.id.txtBtnRegistro)
        val correo = rootView.findViewById<EditText>(R.id.idEmail)
        val contr = rootView.findViewById<EditText>(R.id.idPass)
        val txtMensaje = rootView.findViewById<TextView>(R.id.txtMensaje)
        val iBtnGoogle = rootView.findViewById<ImageButton>(R.id.iBtnGoogle)

       /* session()*/

        //GoogleAnalytics(Evento)
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        val bundle = Bundle()
        bundle.putString("message", "Integracion de firebase completo")
        analytics.logEvent("InitScreen", bundle)

        setup(btnIngresar, correo, contr)

        btnRegistrar.setOnClickListener {
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 100)
            startActivity(intent)
        }

        iBtnGoogle.setOnClickListener {
            //Autenticacion con google
//            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()

            /*val googleClient = GoogleSignIn.getClient(requireContext(), googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)*/
        }

        //Login con Facebook
        val iBtnFacebook = rootView.findViewById<ImageButton>(R.id.ibtnfacebook)
        /*iBtnFacebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult?) {
                        result?.let {
                            val token = it.accessToken
                            val credential = FacebookAuthProvider.getCredential(token.token)
                            FirebaseAuth.getInstance().signInWithCredential(credential)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        irASeleccioDePersonaje()
                                        val PrefsFacebook = requireContext().getSharedPreferences(
                                            getString(R.string.prefFacebook_file),
                                            Context.MODE_PRIVATE
                                        ).edit()
                                        PrefsFacebook.putString("correo", "facebook")
                                        PrefsFacebook.apply()
                                    } else {
                                        mostrarError()
                                    }
                                }
                        }
                    }

                    override fun onCancel() {

                    }

                    override fun onError(error: FacebookException?) {
                        mostrarError()
                    }
                })
        }*/

        return rootView
    }
    override fun onStart() {
        super.onStart()
        val authLayout = requireView().findViewById<ConstraintLayout>(R.id.authLayout)
        authLayout.visibility = View.VISIBLE
    }

   /* private fun session() {
        val authLayout = requireView().findViewById<ConstraintLayout>(R.id.authLayout)
        authLayout.visibility = View.INVISIBLE
        val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val correo = prefs.getString("correo", null)
        Log.d("correo", "correo es $correo")
        if (correo != null) {
            val intent = Intent(requireContext(), MainActivitySelecct::class.java)
            startActivity(intent)
        }
    }*/

    private fun setup(
        btnIngresar: Button,
        correo: EditText,
        contr: EditText,
    ) {
        btnIngresar.setOnClickListener {
            if (correo.text.isNotEmpty() && contr.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    correo.text.toString(),
                    contr.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(requireContext(), MenuEleccion::class.java))
                        Toast.makeText(requireContext(), "BIENVENIDO", Toast.LENGTH_SHORT).show()
                        val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                        prefs.putString("correo", correo.text.toString())
                        prefs.apply()
                    } else {
                        mostrarError()
                    }
                }
            } else {
                if (correo.text.isEmpty())
                    correo.error = "Completa este campo"
                else if (contr.text.isEmpty())
                    contr.error = "Completa este campo"
            }
        }
    }

    private fun mostrarError() {
        val btnRegistrar = requireView().findViewById<TextView>(R.id.txtBtnRegistro)
        val txtMensaje = requireView().findViewById<TextView>(R.id.txtMensaje)
        val colorOriginal = btnRegistrar.currentTextColor
        val tipoLetra = btnRegistrar.typeface
        txtMensaje.text = "Aun no estas registrado"
        btnRegistrar.setTextColor(Color.parseColor("#FF009688"))
        btnRegistrar.setTypeface(null, Typeface.BOLD)
        Handler().postDelayed({
            btnRegistrar.setTextColor(colorOriginal)
            btnRegistrar.setTypeface(tipoLetra)
        }, 3000)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /*callbackManager.onActivityResult(requestCode, resultCode, data)*/
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                    irASeleccioDePersonaje()
                } else {
                    mostrarError()
                }
            }catch (e: ApiException){
                mostrarError()
            }
        }
    }
    fun irASeleccioDePersonaje(){
//        Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.ContenedorP_Principales, FragmentAvatar2())
        Toast.makeText(requireContext(), "Bienvenido", Toast.LENGTH_SHORT).show()
    }
}