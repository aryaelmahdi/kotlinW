package com.yuu.com
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class comics(
    val title: String,
    val desc: String,
    val image: Int,
    val preview: String
) :Parcelable
