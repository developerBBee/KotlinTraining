package jp.developer.bbee.kotlintraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialogButton: Button = findViewById(R.id.dialogButton)
        dialogButton.setOnClickListener{
            val dialogFragment = MyDialogFragment()
            dialogFragment.show(supportFragmentManager, "dialog_basic")
        }
    }
}