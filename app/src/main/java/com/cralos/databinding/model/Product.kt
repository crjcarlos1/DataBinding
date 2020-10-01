package com.cralos.databinding.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    var title: String,
    var body: String,
    var image: Int
) : Parcelable