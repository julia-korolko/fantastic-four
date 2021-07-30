package com.juliakorolko.fantasticfour.comicOverview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comic(
    val data: Data
): Parcelable
