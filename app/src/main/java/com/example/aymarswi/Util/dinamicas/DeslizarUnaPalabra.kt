import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class DeslizarUnaPalabra :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {
    private lateinit var selectedView: View
    private lateinit var draggableContainer: ViewGroup
    private lateinit var targetTextView: TextView
    private lateinit var checkButton: Button
    private lateinit var correctAnswer: String

    fun initialize(
        correctAnswer: String,
        targetTextView: TextView,
        draggableContainer: ViewGroup,
        checkButton: Button
    ) {
        this.correctAnswer = correctAnswer
        this.targetTextView = targetTextView
        this.draggableContainer = draggableContainer
        this.checkButton = checkButton

        setupListeners()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupListeners() {
        draggableContainer.children.filterIsInstance<TextView>().forEach { view ->
            view.setOnTouchListener { _, event -> onTouch(view, event) }
        }
        targetTextView.setOnDragListener { _, event -> onDrag(event) }
        checkButton.setOnClickListener { validateAnswer() }
        targetTextView.setOnClickListener { clearAndEnableText() }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> actionDown(view)
            MotionEvent.ACTION_UP -> actionUp()
        }
        return true
    }

    private fun onDrag(event: DragEvent): Boolean {
        when (event.action) {
            DragEvent.ACTION_DROP -> handleDrop(event)
            DragEvent.ACTION_DRAG_ENDED -> if (!event.result) selectedView.visibility = View.VISIBLE
        }
        return true
    }

    private fun actionDown(view: View) {
        selectedView = view.also { it.visibility = View.INVISIBLE }
        val item = ClipData.Item(view.tag as? CharSequence)
        val dragData =
            ClipData((view as TextView).text.toString(), arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
        view.startDragAndDrop(dragData, View.DragShadowBuilder(view), null, 0)
    }

    private fun actionUp() {
        selectedView.visibility = View.VISIBLE
    }

    private fun handleDrop(event: DragEvent) {
        targetTextView.text = event.clipDescription?.label
        disableDraggables()
    }

    private fun clearAndEnableText() {
        if (targetTextView.text.isNotEmpty()) {
            enableDraggables(targetTextView.text.toString())
            targetTextView.text = ""
        }
    }

    private fun validateAnswer() {
        val isCorrect = targetTextView.text.toString().equals(correctAnswer, ignoreCase = true)
        respuesta(isCorrect)
    }

    private fun disableDraggables() {
        draggableContainer.children.forEach { view ->
            if (view is TextView && view.tag?.toString() != correctAnswer){
                view.alpha = 0.5f
                view.setOnTouchListener(null)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun enableDraggables(optionInvisible: String) {
        draggableContainer.children.forEach { view ->
            view.alpha = 1.0f
            if (view is TextView) {
                view.setOnTouchListener { _, event -> onTouch(view, event) }
                showOptionInvisible(view, optionInvisible)
            }
        }
    }

    private fun showOptionInvisible(view: TextView, optionInvisible: String) {
        if (view.text.toString().equals(optionInvisible, ignoreCase = true))
            view.visibility = View.VISIBLE
    }
}
