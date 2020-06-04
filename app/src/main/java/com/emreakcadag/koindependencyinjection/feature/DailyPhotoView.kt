package com.emreakcadag.koindependencyinjection.feature

import android.view.View
import android.view.ViewGroup
import com.emreakcadag.koindependencyinjection.ActivityRetriever
import com.emreakcadag.koindependencyinjection.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 3.06.2020
 *
 */

class DailyPhotoView(
    private val mainView: ViewGroup
) : EventHandler, KoinComponent, LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()
    private val viewModel: MainViewModel by inject()

    override val containerView: View? get() = mainView

    init {
        viewModel.eventHandler = this
        viewModel.getDailyPhoto()
    }

    override fun setDailyPhoto(dailyPhoto: PhotoResponse?) {
        containerView?.run {
            GlideApp
                .with(activityRetriever.context)
                .load("https://media-exp1.licdn.com/dms/image/C4E03AQEBTtu3QMz3cw/profile-displayphoto-shrink_200_200/0?e=1596672000&v=beta&t=pDDdZBahN7eYLQczTeKI6up93GIUPI-o9qTpbzNEhwI")
                // .load(dailyPhoto?.url)
                .into(nasaImage)

            date.text = dailyPhoto?.date
            explanation.text = dailyPhoto?.explanation
        }
    }
}