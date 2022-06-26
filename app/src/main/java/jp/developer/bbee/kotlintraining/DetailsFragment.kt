package jp.developer.bbee.kotlintraining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    private var isTowPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            isTowPane = it.findViewById<FrameLayout>(R.id.detailsFrame) != null // true: x-large
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        (if (isTowPane) arguments else activity?.intent?.extras)?.let {
            val item: Map<String, String> = ListDataSource.getInfoByName(it.getString("name"))
            view.findViewById<TextView>(R.id.name).text = "${it.getString("name")} (${item["alias"]}) "
            view.findViewById<TextView>(R.id.info).text = item["info"]
        }
        return view
    }
}