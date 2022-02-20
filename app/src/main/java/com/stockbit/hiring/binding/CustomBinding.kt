package com.stockbit.hiring.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by Jessica Setyani on 19/02/22.
 */
object CustomBinding {
    @BindingAdapter("android:textBinding")
    fun textBinding(view: TextView, resource: ObservableText) {
        val formatArgs = mutableListOf<String>()
        with(resource) {
            textArgs.forEach {
                if(it is Int) {
                    formatArgs.add(view.context.getString(it))
                } else {
                    formatArgs.add(it.toString())
                }
            }

            val value = get()
            var stringText = ""
            if(value is Int) {
                stringText = if(quantity != null) {
                    view.context.resources.getQuantityString(value, quantity ?: 0)
                } else {
                    view.context.getString(value)
                }
            } else if(value is String) {
                stringText = value
            }
            if(formatArgs.isNotEmpty()) stringText =
                String.format(stringText, *formatArgs.toTypedArray())
            view.text = stringText
        }
    }

}