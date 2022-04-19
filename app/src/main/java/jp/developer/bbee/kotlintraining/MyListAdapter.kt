package jp.developer.bbee.kotlintraining

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyListAdapter (
    private val context: Context,
    private val data: List<ListItem>,
    private val resource: Int
        ) : BaseAdapter() {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): ListItem {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position)
        val sview = convertView ?: inflater.inflate(resource, null)
        sview.findViewById<TextView>(R.id.tvName).text = item.name
        sview.findViewById<TextView>(R.id.tvText).text = item.text
        return sview
    }
}