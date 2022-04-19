package jp.developer.bbee.kotlintraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
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
        val data = listOf(
            mapOf("name" to "Alex", "text" to "I like Pepper."),
            mapOf("name" to "John", "text" to "I like Turmeric."),
            mapOf("name" to "Helen", "text" to "I like Coriander."),
            mapOf("name" to "Bob", "text" to "I like Ginger."),
            mapOf("name" to "Jane", "text" to "I like Garlic."),
        )
        val list = findViewById<ListView>(R.id.lvSpice)
        val adapter = SimpleAdapter(this, data, R.layout.list_item,
            arrayOf("name", "text"), intArrayOf(R.id.tvName, R.id.tvText))
        list.adapter = adapter
         */

        val data = listOf(
            ListItem(1, "Alex","I like Pepper."),
            ListItem(2, "John", "I like Turmeric."),
            ListItem(3, "Helen", "I like Coriander."),
            ListItem(4, "Bob", "I like Ginger."),
            ListItem(5, "Jane", "I like Garlic."),
        )
        val list = findViewById<ListView>(R.id.lvSpice)
        list.adapter = MyListAdapter(this, data, R.layout.list_item)

        /*
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
        */

    }
}