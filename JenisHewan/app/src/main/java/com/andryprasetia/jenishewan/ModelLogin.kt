package com.andryprasetia.jenishewan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelLogin(
    var username :String,
    var Password :String
) : Parcelable

