package com.emreakcadag.koindependencyinjection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreakcadag.koindependencyinjection.network.NASAAPIInterface
import com.emreakcadag.koindependencyinjection.network.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface MainView {
    fun setDailyPhoto(dailyPhoto: PhotoResponse?)
}

class MainViewModel : ViewModel(), KoinComponent {
    private val nasaApiInterface: NASAAPIInterface? by inject()
    var view: MainView? = null

    fun getDailyPhoto() {
        viewModelScope.launch(Dispatchers.IO) {
            val dailyPhoto = nasaApiInterface?.getDailyPhoto()
            withContext(Dispatchers.Main) {
                view?.setDailyPhoto(dailyPhoto)
            }
        }
    }
}