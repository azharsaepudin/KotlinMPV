package com.studio.azhar.kotlinmpv.API

import okhttp3.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("/rest-api/wpu-rest-server/api/mahasiswa")
    fun inputData(
        @Field("nama")nama: String?,
        @Field("email")email: String?): retrofit2.Call<ApiResponse>

}