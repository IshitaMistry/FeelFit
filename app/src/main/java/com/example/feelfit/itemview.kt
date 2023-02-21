package com.example.feelfit

import android.os.Parcel
import android.os.Parcelable

data class itemview(val image: Int, val image1: Int, var text: String?) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeInt(image1)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<itemview> {
        override fun createFromParcel(parcel: Parcel): itemview {
            return itemview(parcel)
        }

        override fun newArray(size: Int): Array<itemview?> {
            return arrayOfNulls(size)
        }
    }

}