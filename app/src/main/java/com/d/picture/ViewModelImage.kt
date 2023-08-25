package com.d.picture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d.picture.Domain.GetImagesUseCases
import com.d.picture.data.network.model.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelImage @Inject constructor(
    private val getImagesUseCases: GetImagesUseCases
) : ViewModel() {

    val images = MutableLiveData<List<Image>>()

    fun onCreate() {
        viewModelScope.launch {
            val result: List<Image>? = getImagesUseCases()
            if (!result.isNullOrEmpty()) {
                images.postValue(result)
            }
        }
    }
}