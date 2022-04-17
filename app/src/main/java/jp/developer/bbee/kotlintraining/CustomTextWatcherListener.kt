package jp.developer.bbee.kotlintraining

import android.text.Editable
import android.view.View

interface CustomTextWatcherListener {
    fun beforeTextChanged(view: View, s: CharSequence?, start: Int, count: Int, after: Int)

    fun onTextChanged(view: View, s: CharSequence?, start: Int, before: Int, count: Int)

    fun afterTextChanged(view: View, p0: Editable?)
}