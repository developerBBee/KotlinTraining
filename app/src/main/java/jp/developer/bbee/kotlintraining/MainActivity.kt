package jp.developer.bbee.kotlintraining

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf<ListItem>(
            ListItem("number01", ContextCompat.getDrawable(this, R.drawable.number01)),
            ListItem("number02", ContextCompat.getDrawable(this, R.drawable.number02)),
            ListItem("number03", ContextCompat.getDrawable(this, R.drawable.number03))
        )

        val myPager = findViewById<ViewPager2>(R.id.myPager)
        myPager.adapter = MyListAdapter(data)

    }
}