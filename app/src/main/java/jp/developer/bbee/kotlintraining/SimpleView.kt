package jp.developer.bbee.kotlintraining

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.sql.Time
import java.util.*
import kotlin.concurrent.timerTask

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    /*
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 5f
        strokeCap = Paint.Cap.SQUARE // BUTT or ROUND or SQUARE
        style = Paint.Style.STROKE // FILL or FILL_AND_STROKE or STROKE

        typeface = Typeface.SERIF
        textSize = 50f
        textAlign = Paint.Align.CENTER
        textScaleX = 1.5f
        textSkewX = -0.5f
    }
     */

    private val rectf = RectF(0f, 0f, 1000f, 1000f)
    private val rectf2 = RectF(250f, 100f, 650f, 500f)
    private val rectf3 = RectF(rectf2).apply { offset(250f, 100f) }
    private val pathClip = Path().apply {
        addOval(rectf2, Path.Direction.CW)
        addOval(rectf3, Path.Direction.CW)
//        addRect(300f, 200f, 700f, 800f,Path.Direction.CW)
    }

    private val rect = Rect(200, 0, 1800, 1600)

    private val bmp = BitmapFactory.decodeResource(resources, R.drawable.img001)

    private val path = Path()

    private var color = Color.BLACK
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }

    private var type = 0
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }

    private val p = Paint()

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.SimpleView, 0, 0).apply {
                try {
                    color = getColor(R.styleable.SimpleView_color, Color.BLACK)
                    type = getInt(R.styleable.SimpleView_type, 0)
                } finally {
                    recycle()
                }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //canvas.drawColor(Color.argb(0xFF, 240, 240, 240))

        // 点を描く
        //canvas.drawPoint(100f, 100f, p)
        //canvas.drawPoints(floatArrayOf(50f, 100f, 80f, 130f, 110f, 160f, 140f, 190f), p)

        // 線を描く
        //canvas.drawLine(10f, 20f, 800f, 550f, p)
        //canvas.drawLines(
        //    floatArrayOf(50f, 100f, 350f, 350f, /**/ 350f, 350f, 575f, 100f, /**/
        //        575f, 100f, 720f, 350f, /**/ 720f, 350f, 900f, 100f), p)

        // 矩形を描く
        //canvas.drawRect(100f, 100f, 400f, 400f, p)

        // 円、楕円を描く
        //canvas.drawCircle(200f, 200f, 100f, p)
        //canvas.drawOval(rectf, p) //rectf に fit する楕円

        // 円弧を描く
        //canvas.drawArc(rectf2, 90f, 150f, true, p)

        // 文字を描く
        //canvas.drawText("文字を描く \'drawText()\'", 400f, 300f, p)

        // 画像を貼る
        //canvas.drawBitmap(bmp, rect, rectf2, p)

        // 変換
        //canvas.translate(200f, 100f)
        //canvas.scale(1.2f, 1.2f)
        //canvas.rotate(20f)
        //canvas.skew(-0.1f, 0.5f)
        //canvas.drawBitmap(bmp, rect, rectf2, p)

        //canvas.drawPath(
        //    path.apply {
        //        moveTo(150f, 200f)
        //        lineTo(800f, 500f)
        //        lineTo(200f, 150f)
        //        lineTo(850f, 450f)
        //    },
        //    p
        //)
        //canvas.drawPath(
        //    path.apply {
        //        moveTo(200f, 200f)
        //        cubicTo(200f, 200f, 500f, 1200f, 800f, 200f)
        //    },
        //    p
        //)
        //canvas.drawPath(
        //    path.apply {
        //        reset()
        //        moveTo(550f, 300f)
        //        lineTo(600f, 650f)
        //        lineTo(650f, 300f)
        //    },p.apply {
        //        strokeWidth = 30f
        //        strokeJoin = Paint.Join.ROUND
        //    }
        //)

        //canvas.clipPath(pathClip)
        //canvas.drawBitmap(bmp, rect, rectf, p)

        p.color = color
        p.strokeWidth = 100f

        when(type) {
            0 -> canvas.drawCircle(200f, 200f, 100f, p)
            1 -> canvas.drawRect(100f, 100f, 400f, 400f, p)
            2 -> canvas.drawLine(10f, 20f, 800f, 500f, p)
            else -> {}
        }
    }

}