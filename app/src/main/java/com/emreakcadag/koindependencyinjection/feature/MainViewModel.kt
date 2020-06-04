package com.emreakcadag.koindependencyinjection.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface EventHandler {
    fun setDailyPhoto(dailyPhoto: PhotoResponse?)
}

class MainViewModel : ViewModel(), KoinComponent {
    private val nasaApiInterface: NASAAPIInterface? by inject()
    var eventHandler: EventHandler? = null

    fun getDailyPhoto() {
        viewModelScope.launch(Dispatchers.IO) {
            val dailyPhoto = nasaApiInterface?.getDailyPhoto()
            withContext(Dispatchers.Main) {
                eventHandler?.setDailyPhoto(dailyPhoto)
            }
        }
    }
}