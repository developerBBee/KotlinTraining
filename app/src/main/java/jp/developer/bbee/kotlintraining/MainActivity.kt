package jp.developer.bbee.kotlintraining

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import jp.developer.bbee.kotlintraining.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var mContext: Context

    var txtResultTextSize = 10.0f
    var enableSave = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this

        txtResultTextSize = binding.txtResult.textSize
        binding.txtResult.setOnClickListener(TextZoomListener())

        binding.btnCurrent.setOnClickListener(
            object: View.OnClickListener {
                override fun onClick(v: View?) {
                    if (enableSave) {
                        binding.txtSavedResult.text = binding.txtResult.text
                    }
                    binding.txtResult.text = Date().toString()
                    enableSave = true
                }
            }
        )

        binding.txtSavedResult.setOnClickListener {
            if (binding.txtSavedResult.textSize > txtResultTextSize) {
                binding.txtSavedResult.textSize = convertPxToSp(txtResultTextSize)
            } else {
                binding.txtSavedResult.textSize = convertPxToSp(txtResultTextSize) + 10.0f
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("txtResult", binding.txtResult.text.toString())
        outState.putString("txtSavedResult", binding.txtSavedResult.text.toString())
        outState.putFloat("txtResultSize", binding.txtResult.textSize)
        outState.putFloat("txtSavedResultSize", binding.txtSavedResult.textSize)
        outState.putBoolean("enableSave", enableSave)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.txtResult.text = savedInstanceState.getString("txtResult")
        binding.txtSavedResult.text = savedInstanceState.getString("txtSavedResult")
        binding.txtResult.textSize = convertPxToSp(
            savedInstanceState.getFloat("txtResultSize"))
        binding.txtSavedResult.textSize = convertPxToSp(
            savedInstanceState.getFloat("txtSavedResultSize"))
        enableSave = savedInstanceState.getBoolean("enableSave")
    }

    private inner class TextZoomListener: View.OnClickListener {
        override fun onClick(v: View?) {
            if (binding.txtResult.textSize > txtResultTextSize) {
                binding.txtResult.textSize = convertPxToSp(txtResultTextSize)
            } else {
                binding.txtResult.textSize = convertPxToSp(txtResultTextSize) + 10.0f
            }
        }
    }

    fun convertDpToPx (dp: Float): Float {
        return dp * mContext.resources.displayMetrics.density
    }

    fun convertPxToDp (px: Float): Float {
        return px / mContext.resources.displayMetrics.density
    }

    fun convertSpToPx (sp: Float): Float {
        return sp * mContext.resources.displayMetrics.scaledDensity
    }

    fun convertPxToSp (px: Float): Float {
        return px / mContext.resources.displayMetrics.scaledDensity
    }
}