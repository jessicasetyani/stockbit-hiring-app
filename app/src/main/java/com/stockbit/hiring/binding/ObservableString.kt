package com.stockbit.hiring.binding

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import java.io.Serializable

/**
 * Created by Jessica Setyani on 19/02/22.
 */
class ObservableString() : BaseObservable(), Serializable, Parcelable {

    internal var value: String = ""

    val length: Int = value.length

    constructor(value: String?) : this() {
        this.value = value ?: ""
    }

    fun get(): String = value

    fun set(value: String?) {
        this.value = value ?: ""
        notifyChange()
    }

    fun isEmpty(): Boolean = value.isEmpty()

    override fun toString(): String {
        return value
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(value)
    }

    fun clear() {
        value = ""
        notifyChange()
    }

    @JvmField
    val CREATOR: Parcelable.Creator<ObservableString> = object : Parcelable.Creator<ObservableString> {

        override fun createFromParcel(source: Parcel): ObservableString {
            return ObservableString(source.readString())
        }

        override fun newArray(size: Int): Array<ObservableString?> {
            return arrayOfNulls(size)
        }
    }
}