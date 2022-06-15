package jp.developer.bbee.kotlintraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    val data: List<RecyclerItem> = listOf(
        RecyclerItem(1, "Core i7 12700 BOX", "Intel", "LGA1700 12コア20スレッド 2.1～4.9GHz"),
        RecyclerItem(2, "Core i5 12400F BOX", "Intel", "LGA1700 6コア12スレッド 2.5～4.4GHz"),
        RecyclerItem(3, "Ryzen 5 5600X BOX", "AMD", "AM4 6コア12スレッド 3.7～4.6GHz"),
        RecyclerItem(4, "Ryzen 5 5600G BOX", "AMD", "AM4 6コア12スレッド 3.9～4.4GHz"),
        RecyclerItem(5, "Ryzen 9 5900X BOX", "AMD", "AM4 12コア24スレッド 3.7～4.8GHz"),
        RecyclerItem(6, "Ryzen 7 5700X BOX", "AMD", "AM4 8コア16スレッド 3.4～4.6GHz"),
        RecyclerItem(7, "Core i5 12400 BOX", "Intel", "LGA1700 6コア12スレッド 2.5～4.4GHz"),
        RecyclerItem(8, "Core i3 12100F BOX", "Intel", "LGA1700 4コア8スレッド 3.3～4.3GHz"),
        RecyclerItem(9, "Ryzen 9 5950X BOX", "AMD", "AM4 16コア32スレッド 3.4～4.9GHz"),
        RecyclerItem(10, "Core i5 12600K BOX", "Intel", "LGA1700 10コア16スレッド 3.7～4.9GHz"),
        RecyclerItem(11, "Core i7 12700K BOX", "Intel", "LGA1700 12コア20スレッド 3.6～5GHz"),
        RecyclerItem(12, "Core i3 12100 BOX", "Intel", "LGA1700 4コア8スレッド 3.3～4.3GHz"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this).apply {
//            orientation = LinearLayoutManager.VERTICAL
//        }
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = MyRecyclerAdapter(data)
    }
}