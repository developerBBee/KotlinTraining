package jp.developer.bbee.kotlintraining

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val path = Path()

    private val p = Paint().apply {
        color = Color.BLUE
        strokeWidth = 3f
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return
        canvas.drawPath(path, p)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(event.x, event.y)
            MotionEvent.ACTION_MOVE -> path.lineTo(event.x, event.y)
            MotionEvent.ACTION_UP -> {
                performClick()
                path.lineTo(event.x, event.y)
            }
        }

        invalidate()
        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}