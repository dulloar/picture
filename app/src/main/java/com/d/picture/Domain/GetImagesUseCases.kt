package com.d.picture.Domain

import com.d.picture.data.ImageRepository
import com.d.picture.data.network.Service.IImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetImagesUseCases @Inject constructor(
    private val imageRepository: ImageRepository
){
    suspend operator fun invoke() =  imageRepository.getAllImages()
}