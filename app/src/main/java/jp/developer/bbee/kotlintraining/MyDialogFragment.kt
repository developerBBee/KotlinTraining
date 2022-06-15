package jp.developer.bbee.kotlintraining

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("Basic of Dialog")
                setMessage("Hello World!")
                setIcon(androidx.appcompat.R.drawable.abc_btn_radio_material)

                setPositiveButton("Yes") { dialog, which ->
                    Toast.makeText(activity, "Done!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("No") { dialog, which ->
                    Toast.makeText(activity, "Deny", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("Cancel") { dialog, which -> } // Close dialog without action
            }.create()
        }

        // Elvis operation :: dialog!=null -> dialog / dialog==null -> throw exception
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}