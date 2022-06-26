package jp.developer.bbee.kotlintraining

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var mPreferences: SharedPreferences
    private lateinit var mEditor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val changeTheme = intent.extras?.get("changeTheme")
        mPreferences = getSharedPreferences("themeData", MODE_PRIVATE)
        setTheme(mPreferences.getInt("theme", R.style.Theme_KotlinTraining))

        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main_motionbasic)

        mEditor = mPreferences.edit()

        val motion = findViewById<MotionLayout>(R.id.motion)
        when (changeTheme) {
            "a" -> motion.transitionToEnd()
            "b" -> motion.transitionToStart()
        }

        findViewById<Button>(R.id.btn).setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            if (motion.currentState == R.id.start) {
                newIntent.putExtra("changeTheme", "a")
                mEditor.putInt("theme", com.google.android.material.R.style.Theme_MaterialComponents)
            } else {
                newIntent.putExtra("changeTheme", "b")
                mEditor.putInt("theme", R.style.Theme_KotlinTraining)
            }
            mEditor.commit() // Use commit(), reason that activity finished before applying since apply() is async.
            finish()
            startActivity(newIntent)
        }
    }
}