package jp.developer.bbee.kotlintraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import jp.developer.bbee.kotlintraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binder: ActivityMainBinding
    var visibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

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
}