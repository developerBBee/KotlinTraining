package jp.developer.bbee.kotlintraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(private val data: List<RecyclerItem>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = data[position].title
        holder.tagTextView.text = data[position].tag
        holder.descTextView.text = data[position].desc
    }

    override fun getItemCount(): Int {
        return data.size
    }

}