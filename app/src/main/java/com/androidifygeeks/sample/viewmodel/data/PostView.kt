package com.androidifygeeks.sample.viewmodel.data

import android.os.Parcel
import android.os.Parcelable

/**
 * @author ashish on 11,December,2018
 */
data class PostView(val userId : Int, val id: Int, val title: String, val body: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(body)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostView> {
        override fun createFromParcel(parcel: Parcel): PostView {
            return PostView(parcel)
        }

        override fun newArray(size: Int): Array<PostView?> {
            return arrayOfNulls(size)
        }
    }
}