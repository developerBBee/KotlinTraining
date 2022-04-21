package jp.developer.bbee.kotlintraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyListAdapter(private val data: List<ListItem>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = data[position].title
        holder.numImageView.setImageDrawable(data[position].photo)
        holder.numImageView.contentDescription = data[position].title
    }

    override fun getItemCount(): Int {
        return data.size
    }

}