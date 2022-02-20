package com.stockbit.hiring.binding

import androidx.annotation.ColorRes
import androidx.annotation.PluralsRes
import androidx.databinding.BaseObservable

/**
 * Created by Jessica Setyani on 19/02/22.
 */
class ObservableText() : BaseObservable() {

    private var textValue: String = ""
    private var textRes: Int = 0
    val textArgs: MutableList<Any> = mutableListOf()
    var quantity: Int? = null

    data class SpanText(
        val highlight: Any? = null,
        val click: (() -> Unit)? = null,
        val backgroundColor: Int = 0,
        @ColorRes val textColor: Int = 0,
        val isUnderline: Boolean = false,
        val isBold: Boolean = false,
        val isItalic: Boolean = false
    )

    constructor(textRes: Int?) : this() {
        this.textRes = textRes ?: 0
    }

    constructor(text: String?) : this() {
        this.textValue = text ?: ""
    }

    fun get(): Any {
        return if(textRes != 0) {
            this.textRes
        } else {
            textValue
        }
    }

    fun set(value: String?) {
        clear()
        this.textValue = value ?: ""
        notifyChange()
    }

    fun setPlurals(@PluralsRes value: Int, quantity: Int, vararg args: Any?) {
        clear()
        this.textRes = value
        args.forEach { if(it != null) textArgs.add(it) }
        this.quantity = quantity
        notifyChange()
    }

    fun set(value: String?, vararg args: Any?) {
        clear()
        this.textValue = value ?: ""
        args.forEach { if(it != null) textArgs.add(it) }
        notifyChange()
    }

    fun set(value: Int?) {
        clear()
        this.textRes = value ?: 0
        notifyChange()
    }

    fun set(value: Int?, vararg args: Any?) {
        clear()
        this.textRes = value ?: 0
        args.forEach { if(it != null) textArgs.add(it) }
        notifyChange()
    }

    fun clear() {
        textArgs.clear()
        textValue = ""
        textRes = 0
    }

}