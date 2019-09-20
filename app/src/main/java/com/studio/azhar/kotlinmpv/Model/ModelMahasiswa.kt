package com.studio.azhar.kotlinmpv.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class ModelMahasiswa (

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("email")
    val email: String? = null



)
