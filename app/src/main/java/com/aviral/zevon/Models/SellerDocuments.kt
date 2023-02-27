package com.aviral.zevon.Models

import android.os.Parcel
import android.os.Parcelable

data class SellerDocuments(
    var aadharLocation: String?,
    var panLocation: String?,
    var gstinLocation: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(aadharLocation)
        parcel.writeString(panLocation)
        parcel.writeString(gstinLocation)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SellerDocuments> {
        override fun createFromParcel(parcel: Parcel): SellerDocuments {
            return SellerDocuments(parcel)
        }

        override fun newArray(size: Int): Array<SellerDocuments?> {
            return arrayOfNulls(size)
        }
    }
}