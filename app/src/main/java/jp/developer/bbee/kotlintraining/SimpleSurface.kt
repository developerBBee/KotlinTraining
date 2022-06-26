package jp.developer.bbee.kotlintraining

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.concurrent.Executors

class SimpleSurface(context: Context, attrs: AttributeSet) : SurfaceView(context, attrs) {
    private val service = Executors.newSingleThreadExecutor()
    private val p = Paint().apply {
        color = Color.BLUE
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {}

            override fun surfaceCreated(holder: SurfaceHolder) {
                draw(holder)
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                this@SimpleSurface.service.shutdown()
            }
        })
    }
    private fun draw(holder: SurfaceHolder) {
        service.execute {
            for (i in 0..999) {
                val canvas = holder.lockCanvas().apply {
                    drawColor(Color.WHITE)
                    drawCircle((100 + i).toFloat(), (100 + i).toFloat(), 50f, p)
                }
                holder.unlockCanvasAndPost(canvas)
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }

    /*
    private val path = Path()
    private val p = Paint().apply {
        color = Color.BLUE
        strokeWidth = 3f
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        holder.addCallback(
            object : SurfaceHolder.Callback {
                override fun surfaceChanged(
                    holder: SurfaceHolder,
                    format: Int,
                    width: Int,
                    height: Int
                ) {}

                override fun surfaceCreated(holder: SurfaceHolder) {
                    draw(holder)
                }

                override fun surfaceDestroyed(holder: SurfaceHolder) {}
            }
        )
    }
     */

    /*
    init {
        holder.addCallback(
            object : SurfaceHolder.Callback {
                override fun surfaceChanged(
                    holder: SurfaceHolder,
                    format: Int,
                    width: Int,
                    height: Int
                ) {}

                override fun surfaceCreated(holder: SurfaceHolder) {
                    draw(holder)
                }

                override fun surfaceDestroyed(holder: SurfaceHolder) {}
            }
        )
    }
     */

    /*
    private fun draw(holder: SurfaceHolder) {
        val canvas = holder.lockCanvas().apply {
            drawColor(Color.WHITE)
            //drawRect(100f, 100f, 400f, 400f, p)
            drawPath(path, p)
        }
        holder.unlockCanvasAndPost(canvas)
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
        draw(holder)
        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
     */
}