import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.model.profileUser.Profile
import com.example.aymarswi.util.Datos
import com.google.firebase.firestore.DocumentSnapshot

class UIProfile(fragment: View){
    private lateinit var fragment: View
    private lateinit var imageProfile: ImageView
    private lateinit var nameUsersProfile: TextView
    private lateinit var maxPrize: ImageView
    private lateinit var level: TextView
    private lateinit var txtLevelStar: TextView
    private lateinit var txtTrophies: TextView
    private lateinit var txtGoldMedals: TextView
    private lateinit var txtSilverMedals: TextView
    private var userData: DocumentSnapshot? = null


    init {
        setDataInAlertDialog()
    }

    fun setDataInAlertDialog(){
        getReferenceViewsFragment()
        getDocument()
        setDataInUI()
    }
   
    fun getReferenceViewsFragment(){
         imageProfile = fragment.findViewById(R.id.imgPersonaje1)
         nameUsersProfile = fragment.findViewById(R.id.txtNombrePersonaje)
         maxPrize = fragment.findViewById(R.id.mObtenidas)
         level = fragment.findViewById(R.id.txtNivel)
         txtLevelStar = fragment.findViewById(R.id.txtNivelEstrella)
         txtTrophies = fragment.findViewById(R.id.txtTrofeosObtenidos)
         txtGoldMedals = fragment.findViewById(R.id.txtMedallasDoradas)
         txtSilverMedals = fragment.findViewById(R.id.txtMedallasPlateadas)
    }

    fun getDocument(){
        userData = Profile().getDataUserFromFirebase("hola")
    }
    @SuppressLint("SetTextI18n")
    fun setDataInUI(){
        imageProfile =
        nameUsersProfile.setImageResource(idImagenIconos)
        maxPrize.setImageResource(Datos().determinarNivel(userData?.getString("estrellas")!!.toInt(), userData?.getString("trofeos")!!.toInt(), userData?.getString("medallas doradas")!!.toInt(), userData?.getString("medallas plateadas")!!.toInt()))
        level.text = "Nivel estrella: ${userData?.get("nivel") as String}"
        txtLevelStar.text = "Trofeos obtenidos: ${userData?.getLong("trofeos")?: 0}"
        txtGoldMedals.text = "Medallas doradas: ${userData?.getLong("medallas doradas")?: 0}"
        txtSilverMedals.text = "Medallas plateadas: ${userData?.getLong("medallas plateadas")?: 0}"
    }
}