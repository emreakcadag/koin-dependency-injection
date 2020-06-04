package com.emreakcadag.koindependencyinjection

import android.content.Context
import android.view.LayoutInflater

class ActivityRetriever(private val defaultCurrentActivityListener: DefaultCurrentActivityListener) {

    val layoutInflater = LayoutInflater.from(defaultCurrentActivityListener.currentActivity)

    val context: Context = defaultCurrentActivityListener.context

    fun getActivity() = defaultCurrentActivityListener.currentActivity
}