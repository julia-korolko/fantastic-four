package com.juliakorolko.fantasticfour.comicOverview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val results: List<BookInfo>
): Parcelable
