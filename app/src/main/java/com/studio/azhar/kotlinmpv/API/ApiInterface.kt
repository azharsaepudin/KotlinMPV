package com.studio.azhar.kotlinmpv.API

import retrofit2.Call
import retrofit2.http.*
interface ApiInterface {

    @FormUrlEncoded
    @POST("/rest-api/wpu-rest-server/api/mahasiswa")
    fun inputData(
        @Field("nama")nama: String?,
        @Field("email")email: String?): Call<ApiResponse>

    @FormUrlEncoded
    @PUT("/rest-api/wpu-rest-server/api/mahasiswa")
    fun updateData(
        @Field("id")id: String?,
        @Field("nama")nama: String?): Call<ApiResponse>

}