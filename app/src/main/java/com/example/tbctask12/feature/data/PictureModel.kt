package com.example.tbctask12.feature.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class PictureModel(
    val imageTitle: String,
    val imageDescription:String,
    @DrawableRes val imageRes: Int,
    val Type: AnimalType
):Parcelable