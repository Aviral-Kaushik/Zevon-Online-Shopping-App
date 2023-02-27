package com.aviral.zevon.Models

import android.os.Parcel
import android.os.Parcelable

data class Rating(var username: String?,
                  var rating: Double, var comment: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeDouble(rating)
        parcel.writeString(comment)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rating> {
        override fun createFromParcel(parcel: Parcel): Rating {
            return Rating(parcel)
        }

        override fun newArray(size: Int): Array<Rating?> {
            return arrayOfNulls(size)
        }
    }


}