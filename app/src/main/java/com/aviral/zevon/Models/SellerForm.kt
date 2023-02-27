package com.aviral.zevon.Models

import android.os.Parcel
import android.os.Parcelable

data class SellerForm(
    var name: String?,
    var comapny: String?,
    var country: String?,
    var number: String?,
    var pan: String?,
    var gstin: String?,
    var aadhar: String?): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(comapny)
        parcel.writeString(country)
        parcel.writeString(number)
        parcel.writeString(pan)
        parcel.writeString(gstin)
        parcel.writeString(aadhar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SellerForm> {
        override fun createFromParcel(parcel: Parcel): SellerForm {
            return SellerForm(parcel)
        }

        override fun newArray(size: Int): Array<SellerForm?> {
            return arrayOfNulls(size)
        }
    }

}