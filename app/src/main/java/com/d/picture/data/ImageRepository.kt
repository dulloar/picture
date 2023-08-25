package com.d.picture.data

import com.d.picture.data.network.Service.ImagesServices
import com.d.picture.data.network.model.Image
import com.d.picture.data.network.model.ImagesProvides
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val imagesServices: ImagesServices,
    private val imagesProvides: ImagesProvides
){

        suspend fun getAllImages(): List<Image> {
            val response = imagesServices.getImages()
            imagesProvides.images = response
            return response
        }
}