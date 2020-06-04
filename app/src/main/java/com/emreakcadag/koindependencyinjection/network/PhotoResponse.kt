package com.emreakcadag.koindependencyinjection.network

import com.squareup.moshi.Json

/*
{
"date": "2019-10-19",
"explanation": "The failed unit was beyond the reach of the robotic Canadarm2.  Therefore, this repair of the International Space Station would require humans. The humans on duty were NASA's Jessica Meir and Christina Koch. This was the fourth spacewalk for Koch, the first for Meir, and the first all-female spacewalk in human history.  The first woman to walk in space was Svetlana Savitskaya in 1984.  Koch (red stripe) and Meir are pictured hard at work on the P6 Truss, with solar panels and the darkness of space in the background.  Working over seven hours, the newly installed Battery Charge / Discharge Unit (BCDU) was successfully replaced and, when powered up, operated normally.",
"hdurl": "https://apod.nasa.gov/apod/image/1910/KochMeirISS_NASA_734.jpg",
"media_type": "image",
"service_version": "v1",
"title": "All Female Spacewalk Repairs Space Station",
"url": "https://apod.nasa.gov/apod/image/1910/KochMeirISS_NASA_960.jpg"
}
*/
data class PhotoResponse(
    val date: String? = null,
    val explanation: String? = null,
    @Json(name = "media_type") val mediaType: String? = null,
    @Json(name = "service_version") val serviceVersion: String? = null,
    val title: String? = null,
    val url: String? = null
)