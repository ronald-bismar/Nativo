import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class DeslizarPalabras :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {

    private lateinit var selectedView: View
    private lateinit var myShadow: MyDragShadowBuilder

    @SuppressLint("ClickableViewAccessibility")
    fun deslizarPalabras(
        contenedorPalabrasEspanol: ConstraintLayout,
        contenedorBotonesArrastrables: ViewGroup
    ) {
        configDragListener(contenedorPalabrasEspanol)

        for (i in 0 until contenedorBotonesArrastrables.childCount) {
            val textView = contenedorBotonesArrastrables.getChildAt(i) as TextView
            textView.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        selectedView = view
                        val item = ClipData.Item(view.tag as? CharSequence)
                        val dragData = ClipData(view.tag as CharSequence, arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
                        myShadow = MyDragShadowBuilder(view)
                        view.startDragAndDrop(dragData, myShadow, null, 0)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun configDragListener(contenedorPalabrasEspanol: ConstraintLayout) {
        val dragListener = View.OnDragListener { view, dragEvent ->
            val receiverView: View = view as View

            when (dragEvent.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    receiverView.visibility = View.INVISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    if(dragEvent.clipDescription.label == receiverView.tag as String){
                        receiverView.setBackgroundColor(Color.YELLOW)
                    }else{
                        receiverView.setBackgroundColor(Color.CYAN)
                    }
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DRAG_EXITED -> {
                    if(dragEvent.clipDescription.label == receiverView.tag as String){
                        receiverView.setBackgroundColor(Color.GREEN)
                        view.invalidate()
                    }
                    true
                }
                DragEvent.ACTION_DROP -> true
                DragEvent.ACTION_DRAG_ENDED -> true
                else -> false
            }
        }
        for (i in 0 until contenedorPalabrasEspanol.childCount) {
            val opcion = contenedorPalabrasEspanol.getChildAt(i) as LinearLayout
            (opcion.getChildAt(1)).setOnDragListener(dragListener)
        }
    }
}
class MyDragShadowBuilder(private val v: View): View.DragShadowBuilder(v){
    override fun onProvideShadowMetrics(
        outShadowSize: Point?,
        outShadowTouchPoint: Point?
    ) {
        super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint)
        outShadowSize?.set(view.width, view.height)
        outShadowTouchPoint?.set(view.width/2, view.height/2)
    }

    override fun onDrawShadow(canvas: Canvas) {
        super.onDrawShadow(canvas)
        v.draw(canvas)
    }
}