package net.lynqfy.offical.timeline.model

import android.os.Parcel
import android.os.Parcelable

class TimeLineModel(
    var message: String?,
    var date: String?,
    var status: OrderStatus
) : Parcelable {


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
        parcel.writeString(date)
        parcel.writeInt(status.ordinal)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimeLineModel> {
        override fun createFromParcel(parcel: Parcel): TimeLineModel {
            return TimeLineModel(parcel)
        }

        override fun newArray(size: Int): Array<TimeLineModel?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        OrderStatus.create(parcel.readInt())
    )
}