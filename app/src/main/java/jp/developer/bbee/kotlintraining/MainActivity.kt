package jp.developer.bbee.kotlintraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<String>("Pepper", "Turmeric", "Coriander", "Ginger", "Garlic",
            "Saffron", "Nutmeg", "Cinnamon", "Pepper powder", "Turmeric powder", "Coriander powder", "Ginger powder", "Garlic powder",
            "Saffron powder", "Nutmeg powder", "Cinnamon powder")

        val list = findViewById<ListView>(R.id.lvSpice);
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data)
        list.adapter = adapter

        list.setOnItemClickListener{ av, view, position, id ->
            //adapter.remove((view as TextView).text as String)
            Toast.makeText(this@MainActivity, "${(view as TextView).text}", Toast.LENGTH_SHORT).show()
        }
    }
}