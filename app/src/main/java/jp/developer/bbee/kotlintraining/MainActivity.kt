package jp.developer.bbee.kotlintraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import java.io.FileNotFoundException
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    val TAG = "MemoAppReadWriteFile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMemo = findViewById<EditText>(R.id.etMemo)

        if (Intent.ACTION_VIEW.equals(intent.action)) {
            Log.d(TAG, "get intent action VIEW " + intent.data)
            intent.data?.let {
                val str = StringBuilder()
                contentResolver.openInputStream(it)?.bufferedReader()?.forEachLine {
                    str.append(it)
                    str.append(System.getProperty("line.separator"))
                }
                etMemo.setText(str.toString())
            }
        } else {
            Log.d(TAG, "intent null")
        }

        val readFileOpen =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.data?.let {
                    val str = StringBuilder()
                    contentResolver.openInputStream(it)?.bufferedReader()?.forEachLine {
                        str.append(it)
                        str.append(System.getProperty("line.separator"))
                    }
                    etMemo.setText(str.toString())
                }
            }
        }

        findViewById<Button>(R.id.btnRead).setOnClickListener {
            readFileOpen.launch(Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TITLE, "memo.txt")
            })
        }

        /*
        val str = StringBuilder()
        try {
            openFileInput("memo.txt")?.bufferedReader()?.forEachLine {
                str.append(it)
                str.append(System.getProperty("line.separator"))
            }
        } catch (e : FileNotFoundException) {
            Log.d(TAG, e.stackTraceToString())
        }
        etMemo.setText(str.toString())
         */

        val startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                result.data?.data?.let {
                    contentResolver.openOutputStream(it)?.bufferedWriter()?.use {
                        it.write(etMemo.text.toString())
                    }
                }
            }
        }

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            startForResult.launch(
                Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TITLE, "memo.txt")
                }
            )
        }
    }
}