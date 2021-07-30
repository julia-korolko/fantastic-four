package com.juliakorolko.fantasticfour.comicOverview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookInfo(
    val title: String,
    val description: String,
    val thumbnail : Thumbnail
): Parcelable
