package jp.developer.bbee.kotlintraining

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        var counter = intent?.extras?.getInt("counter") ?: 0
        counter++

        val intentToSub = Intent(this, SubActivity::class.java).putExtra("counter", counter)
        findViewById<TextView>(R.id.tvMain).apply {
            text = counter.toString()
            setOnClickListener {
                startActivity(intentToSub)
            }
        }
         */

        /*
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val uriText = findViewById<EditText>(R.id.et)
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(uriText.text.toString())
                )
            )
        }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            val searchText = findViewById<EditText>(R.id.et2)
            startActivity(
                Intent(
                    Intent.ACTION_WEB_SEARCH
                ).putExtra(SearchManager.QUERY, searchText.text.toString())
            )
        }

        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener {
            val messageText = findViewById<EditText>(R.id.et3)
            startActivity(
                Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, messageText.text.toString())
                }
            )
        }
         */
    }
}