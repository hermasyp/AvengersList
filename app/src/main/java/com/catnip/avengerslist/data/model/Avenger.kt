package com.catnip.avengerslist.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@Parcelize
data class Avenger(
    val name: String,
    val power: String,
    val profileDesc: String,
    val profilePictUrl: String
) : Parcelable
