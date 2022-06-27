package com.kmm.myapplication.android.screen.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailScreenArgument(
    val title: String
) : Parcelable