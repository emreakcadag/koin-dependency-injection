package com.emreakcadag.koindependencyinjection.di

import com.emreakcadag.koindependencyinjection.ActivityRetriever
import com.emreakcadag.koindependencyinjection.DefaultCurrentActivityListener
import com.emreakcadag.koindependencyinjection.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Emre Akçadağ on 3.06.2020
 *
 */

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }

    viewModel { MainViewModel() }
}