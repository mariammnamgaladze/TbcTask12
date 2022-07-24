package com.example.tbctask12.feature.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 enum class AnimalType (val animalType: String): Parcelable {
     DOG("DOG"),
     CAT("CAT")
}