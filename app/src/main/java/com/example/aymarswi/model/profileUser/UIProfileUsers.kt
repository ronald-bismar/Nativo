import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.aymarswi.ApiRest.User
import com.example.aymarswi.R
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers

class UIProfileUsers(activity: Activity){
    private var activity: Activity
    private var fragment: View
    private lateinit var imageProfile: ImageView
    private lateinit var nameUserProfile: TextView
    private lateinit var maxPrize: ImageView
    private lateinit var level: TextView
    private lateinit var txtLevelStar: TextView
    private lateinit var txtTrophies: TextView
    private lateinit var txtGoldMedals: TextView
    private lateinit var txtSilverMedals: TextView

    init {
        this.activity = activity
        this.fragment = View.inflate(activity, R.layout.fragmento_personaje, null)
        setDataInAlertDialog()
    }

    fun setDataInAlertDialog(){
        getReferenceViewsFragment()
        setDataInUI()
    }


    fun getReferenceViewsFragment(){
         imageProfile = fragment.findViewById(R.id.imgPersonaje1)
         nameUserProfile = fragment.findViewById(R.id.txtNombrePersonaje)
         maxPrize = fragment.findViewById(R.id.mObtenidas)
         level = fragment.findViewById(R.id.txtNivel)
         txtLevelStar = fragment.findViewById(R.id.txtNivelEstrella)
         txtTrophies = fragment.findViewById(R.id.txtTrofeosObtenidos)
         txtGoldMedals = fragment.findViewById(R.id.txtMedallasDoradas)
         txtSilverMedals = fragment.findViewById(R.id.txtMedallasPlateadas)
    }

    @SuppressLint("SetTextI18n")
    fun setDataInUI(){
        val user: User = SharedPreferencesUsers.getProfileOfPreferences(activity)
        imageProfile.setImageResource(user.imageProfileR.toInt())
        nameUserProfile.text = user.name
//        maxPrize.setImageResource(Datos().determinarNivel(userData?.getString("estrellas")!!.toInt(), userData?.getString("trofeos")!!.toInt(), userData?.getString("medallas doradas")!!.toInt(), userData?.getString("medallas plateadas")!!.toInt()))
        level.text = "Nivel estrella: ${ user.level }"
        txtLevelStar.text = "Trofeos obtenidos: ${ user.estrellas }"
        txtGoldMedals.text = "Medallas doradas: ${ user.medallasDoradas }"
        txtSilverMedals.text = "Medallas plateadas: ${ user.medallasPlateadas }"
    }
    fun showAlertDialogProfileUser(context: Context){
        val builder = AlertDialog.Builder(context)
        builder.setView(fragment)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
        }
    }
}