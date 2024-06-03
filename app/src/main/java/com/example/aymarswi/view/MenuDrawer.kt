package com.example.aymarswi.view

import android.content.Intent
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.aymarswi.PantallasPrincipales.*
import com.example.aymarswi.PantallasPrincipales.FragmentSeleccionarIdioma.Companion.Idioma
import com.example.aymarswi.R
import com.example.aymarswi.model.profileUser.FirebaseData
import com.example.aymarswi.model.profileUser.SharedPreferencesUsers
import com.google.android.material.navigation.NavigationView

class MenuDrawer(private val activity: AppCompatActivity) :
    NavigationView.OnNavigationItemSelectedListener {

    private val navigationView: NavigationView = activity.findViewById(R.id.nav_view)
    private val drawer: DrawerLayout = activity.findViewById(R.id.drawer_layout)
    private val btnOpenDrawer: ImageView = activity.findViewById(R.id.btnBurger)

    init {
        navigationView.setNavigationItemSelectedListener(this)
        setImageMenuDrawer()
        setOnClickBtnOpenDrawer()
        val menuItem = navigationView.menu.findItem(R.id.itemChangeLanguage)
        menuItem.title = if (Idioma == "Aymara") "Cambiar a Quechua" else "Cambiar a Aymara"
        val idioma = if (Idioma == "Aymara") "Quechua" else "Aymara"
        Idioma = idioma
    }

    private fun setOnClickBtnOpenDrawer() {
        btnOpenDrawer.setOnClickListener { drawer.openDrawer(GravityCompat.START) }
    }

    fun cambiarActivityIdioma() {

        val menuIdioma = if (Idioma == "Aymara") MenuEleccion() else MenuEleccionQ()


        val intent = Intent(activity, menuIdioma::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        activity.startActivity(intent)
        activity.finish()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemChangeLanguage -> cambiarActivityIdioma()
            R.id.itemRanking -> startNewActivity<ActivityContenedor>(97)
            R.id.nav_item_two -> startNewActivity<ContenedorPantallasPrincipales>(10)
            R.id.nav_item_three -> startNewActivity<ContenedorPantallasPrincipales>(33)
            R.id.nav_item_six -> startNewActivity<ContenedorPantallasPrincipales>(20)
            R.id.nav_item_seven -> logoutAndStartNewActivity<ContenedorPantallasPrincipales>(11)
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private inline fun <reified T : AppCompatActivity> startNewActivity(value: Int) {
        val intent = Intent(activity, T::class.java).apply {
            putExtra("valor", value)
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        activity.startActivity(intent)
        activity.finish()
    }

    private inline fun <reified T : AppCompatActivity> logoutAndStartNewActivity(value: Int) {
        SharedPreferencesUsers.clearPreferences(activity)
        FirebaseData.logOutAccount()
        startNewActivity<T>(value)
    }

    private fun setImageMenuDrawer() {
        val imageView: ImageView =
            navigationView.getHeaderView(0).findViewById(R.id.nav_header_imageView)
        val imageResource = SharedPreferencesUsers.getPreferencesUser(activity)
            .getString("imageProfileSquare", "")?.toInt() ?: 0
        imageView.setImageResource(imageResource)
    }
}
