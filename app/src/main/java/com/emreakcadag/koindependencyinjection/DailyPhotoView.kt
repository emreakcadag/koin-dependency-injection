package com.emreakcadag.koindependencyinjection

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.emreakcadag.koindependencyinjection.network.PhotoResponse
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 3.06.2020
 *
 */

class DailyPhotoView(
    private val mainView: ViewGroup,
    viewModel: MainViewModel
) : MainView, KoinComponent, LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()

    override val containerView: View? get() = mainView

    init {
        viewModel.view = this
        viewModel.getDailyPhoto()
    }

    override fun setDailyPhoto(dailyPhoto: PhotoResponse?) {
        mainView.run {
            Glide.with(activityRetriever.context)
                .load(dailyPhoto?.url)
                .into(nasaImage)

            date.text = dailyPhoto?.date
            explanation.text = dailyPhoto?.explanation
        }
    }
}