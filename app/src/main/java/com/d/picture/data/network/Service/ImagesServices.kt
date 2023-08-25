package com.d.picture.data.network.Service

import com.d.picture.data.network.model.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesServices @Inject constructor(private val iImage: IImage){


    suspend fun getImages():List<Image>{
        return withContext(Dispatchers.IO){
                val response = iImage.getImages()
                response.body() ?: emptyList()
            }


    }

}