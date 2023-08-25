package com.d.picture.data.network.Service

import com.d.picture.data.network.model.Image
import retrofit2.Response
import retrofit2.http.GET


interface IImage {

    @GET("list")
    suspend  fun getImages(): Response<List<Image>>

}