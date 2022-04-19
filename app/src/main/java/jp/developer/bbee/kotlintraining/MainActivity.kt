package jp.developer.bbee.kotlintraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<String>("Pepper", "Turmeric", "Coriander", "Ginger", "Garlic",
            "Saffron", "Nutmeg", "Cinnamon", "Pepper powder", "Turmeric powder", "Coriander powder", "Ginger powder", "Garlic powder",
            "Saffron powder", "Nutmeg powder", "Cinnamon powder")

        val list = findViewById<ListView>(R.id.lvSpice)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data)
        list.adapter = adapter
        list.isTextFilterEnabled = true

        list.setOnItemClickListener{ av, view, position, id ->
            //adapter.remove((view as TextView).text as String)
            Toast.makeText(this@MainActivity, "${(view as TextView).text}", Toast.LENGTH_SHORT).show()
        }

        val sv = findViewById<SearchView>(R.id.svSpice)
        sv.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(text: String?): Boolean {
                    if (text.isNullOrBlank()) {
                        list.clearTextFilter()
                    } else {
                        list.setFilterText(text)
                    }
                    return false
                }
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }
            }
        )
    }
}