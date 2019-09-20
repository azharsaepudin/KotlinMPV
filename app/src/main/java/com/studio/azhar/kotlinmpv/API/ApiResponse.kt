package com.studio.azhar.kotlinmpv.API

import com.google.gson.annotations.SerializedName
import com.studio.azhar.kotlinmpv.Model.ModelMahasiswa

data class ApiResponse (

    @field:SerializedName("message")
    val message: String?,

    @field:SerializedName("data")
    val dataMhs: List<ModelMahasiswa>? = null
)
