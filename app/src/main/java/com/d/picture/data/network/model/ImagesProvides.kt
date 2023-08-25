package com.d.picture.data.network.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesProvides @Inject constructor() {
    var images: List<Image> = emptyList()
}