package jp.developer.bbee.kotlintraining

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SeekBar
import jp.developer.bbee.kotlintraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CustomTextWatcherListener {
    private lateinit var binder: ActivityMainBinding
    var visibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.web.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false // The link will be opened in the app without jumping to the browser
            }
        })

        setEditPassword() // password visibility setting

        setSeekColor() // seekbar color setting
        setEditColor() // editText color setting

        setButtonWebView() // web view display on click button setting
    }

    fun setEditPassword() {
        binder.visible.setOnClickListener {
            val position = binder.edit.selectionStart
            if (visibility) {
                binder.edit.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                binder.edit.setSelection(position)
                visibility = false
            } else {
                binder.edit.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                binder.edit.setSelection(position)
                visibility = true
            }
        }
    }

    fun setSeekColor() {
        val listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                when(seekBar?.id) {
                    R.id.seekRed -> {
                        val position = binder.editRed.selectionStart
                        val progressStr = progress.toString()
                        binder.editRed.setText(progressStr)
                        if (progressStr.length > position) {
                            binder.editRed.setSelection(position)
                        } else {
                            binder.editRed.setSelection(progressStr.length)
                        }
                    }
                    R.id.seekGreen -> {
                        val position = binder.editGreen.selectionStart
                        val progressStr = progress.toString()
                        binder.editGreen.setText(progressStr)
                        if (progressStr.length > position) {
                            binder.editGreen.setSelection(position)
                        } else {
                            binder.editGreen.setSelection(progressStr.length)
                        }
                    }
                    R.id.seekBlue -> {
                        val position = binder.editBlue.selectionStart
                        val progressStr = progress.toString()
                        binder.editBlue.setText(progressStr)
                        if (progressStr.length > position) {
                            binder.editBlue.setSelection(position)
                        } else {
                            binder.editBlue.setSelection(progressStr.length)
                        }
                    }
                }
                backgroundColorChange()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        }
        binder.seekRed.setOnSeekBarChangeListener(listener)
        binder.seekGreen.setOnSeekBarChangeListener(listener)
        binder.seekBlue.setOnSeekBarChangeListener(listener)
    }

    fun setEditColor() {
        binder.editRed.apply { addTextChangedListener(CustomWatcher(this, this@MainActivity)) }
        binder.editGreen.apply { addTextChangedListener(CustomWatcher(this, this@MainActivity)) }
        binder.editBlue.apply { addTextChangedListener(CustomWatcher(this, this@MainActivity)) }
    }

    fun backgroundColorChange() {
        val r = binder.seekRed.progress
        val g = binder.seekGreen.progress
        val b = binder.seekBlue.progress
        binder.allLayout.setBackgroundColor(Color.rgb(r, g, b))
    }

    fun setButtonWebView() {
        val listener = View.OnClickListener { view ->
            binder.web.loadUrl(
                when (view?.id) {
                    R.id.btnHome -> "https://github.com"
                    R.id.btnEnv -> "https://github.com/developerBBee"
                    R.id.btnPub -> "https://github.com/developerBBee/mine_layer"
                    else -> "https://github.com"
                }
            )
        }

        binder.btnHome.setOnClickListener(listener)
        binder.btnEnv.setOnClickListener(listener)
        binder.btnPub.setOnClickListener(listener)
    }

    class CustomWatcher(val view: View, val listener: CustomTextWatcherListener) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            listener.beforeTextChanged(view, s, start, count, after)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            listener.onTextChanged(view, s, start, before, count)
        }

        override fun afterTextChanged(s: Editable?) {
            listener.afterTextChanged(view, s)
        }
    }

    override fun beforeTextChanged(view: View, s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(view: View, s: CharSequence?, start: Int, before: Int, count: Int){
    }

    override fun afterTextChanged(view: View, s: Editable?) {
        var i = 0
        try {
            i = s.toString().toInt()
            if (i > 255) {
                i = 255
            }
        } catch (e :NumberFormatException) {
        }
        when (view.id) {
            R.id.editRed -> binder.seekRed.progress = i
            R.id.editGreen -> binder.seekGreen.progress = i
            R.id.editBlue -> binder.seekBlue.progress = i
        }
        backgroundColorChange()
    }
}