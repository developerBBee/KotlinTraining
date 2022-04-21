package jp.developer.bbee.kotlintraining

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    val numImageView: ImageView = itemView.findViewById(R.id.numImageView)
}