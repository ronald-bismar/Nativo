import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.graphics.Point
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class DeslizarPalabras :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {
    private lateinit var selectedView: View
    private lateinit var contenedorBotonesArrastrables: ViewGroup
    private lateinit var contenedorCamposALlenar: ViewGroup
    private var respuestasAcertadas: Int = 0
    private var initialPositionX: Float = 0f
    private var initialPositionY: Float = 0f
    fun deslizarPalabras(
        contenedorCamposALlenar: ViewGroup,
        contenedorBotonesArrastrables: ViewGroup
    ) {
        this.contenedorBotonesArrastrables = contenedorBotonesArrastrables
        this.contenedorCamposALlenar = contenedorCamposALlenar
        setupDragListener(contenedorCamposALlenar)
        setupTouchListener(contenedorBotonesArrastrables)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupTouchListener(contenedorBotonesArrastrables: ViewGroup) {
        contenedorBotonesArrastrables.children.forEach { view ->
            if(view is TextView){
                (view).setOnTouchListener { _, motionEvent ->
                    when (motionEvent.action) {
                        MotionEvent.ACTION_DOWN -> {
                            handleActionDown(view)
                            true
                        }

                        MotionEvent.ACTION_UP -> {
                            handleActionUp()
                            true
                        }
                        else -> false
                    }
                }
            }
        }
    }

    private fun handleActionDown(view: View) {
        selectedView = view
        initialPositionX = selectedView.x
        initialPositionY = selectedView.y
        selectedView.visibility = View.INVISIBLE
        val item = ClipData.Item(view.tag as? CharSequence)
        val dragData =
            ClipData(view.tag as CharSequence, arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
        val myShadow = MyDragShadowBuilder(view)
        view.startDragAndDrop(dragData, myShadow, null, 0)
    }

    private fun handleActionUp() {
        selectedView.visibility = View.VISIBLE
    }

    private fun setupDragListener(contenedorPalabrasEspanol: ViewGroup) {
        val dragListener = View.OnDragListener { view, dragEvent ->
            val receiverView: View = view as View
            when (dragEvent.action) {
                DragEvent.ACTION_DRAG_STARTED -> true
                DragEvent.ACTION_DRAG_ENTERED -> {
                    receiverView.invalidate()
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION -> {
                    true
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    receiverView.background =
                        ContextCompat.getDrawable(instance!!.context, R.drawable.strokedelgado)
                    receiverView.invalidate()
                    true
                }

                DragEvent.ACTION_DROP -> {
                    handleDrop(dragEvent, receiverView)
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    handleDragEnded(dragEvent)
                    true
                }
                else -> false
            }
        }

        contenedorPalabrasEspanol.children.forEach { opcion ->
            (opcion as LinearLayout).getChildAt(1).setOnDragListener(dragListener)
        }
    }

    private fun handleDrop(dragEvent: DragEvent, receiverView: View) {
        Log.d("Respuesta","dragEvent: ${dragEvent.clipDescription?.label}, receiverView ${receiverView.tag}")
        if (dragEvent.clipDescription?.label == receiverView.tag as String) {
            Toast.makeText(instance?.context, "Correcto!", Toast.LENGTH_SHORT).show()
            (receiverView as TextView).text = dragEvent.clipDescription?.label
            respuestasAcertadas += 1
            if (respuestasAcertadas == contenedorCamposALlenar.childCount) respuesta(true)
        } else {
            selectedView.visibility = View.VISIBLE
            selectedView.animate().x(initialPositionX).y(initialPositionY).start()
        }
    }
    private fun handleDragEnded(dragEvent: DragEvent) {
        if (!dragEvent.result) selectedView.visibility = View.VISIBLE
    }
}

class MyDragShadowBuilder(v: View) : View.DragShadowBuilder(v) {
    override fun onProvideShadowMetrics(outShadowSize: Point?, outShadowTouchPoint: Point) {
        super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint)
        outShadowSize?.set(view.width, view.height)
        outShadowTouchPoint?.set(view.width / 2, view.height / 2)
    }
}
