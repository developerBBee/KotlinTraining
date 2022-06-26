package jp.developer.bbee.kotlintraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var counter = intent?.extras?.getInt("counter") ?: 0
        counter++
        val message = intent?.extras?.getString(Intent.EXTRA_TEXT)

        val intentToMain = Intent(this, MainActivity::class.java).putExtra("counter", counter)
        findViewById<TextView>(R.id.tvSub).apply {
            if (message == null) {
                text = counter.toString()
                setOnClickListener {
                    startActivity(intentToMain)
                }
            } else {
                text = message
                setOnClickListener {
                    startActivity(intentToMain)
                }
            }

        }
    }
}