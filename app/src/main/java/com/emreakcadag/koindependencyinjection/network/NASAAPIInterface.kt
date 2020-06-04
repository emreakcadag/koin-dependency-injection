package com.emreakcadag.koindependencyinjection.network

import retrofit2.http.GET

const val API_KEY = "SzVivPLHN7PCYZKtD3PupYZWeKPGTVS0Tx9F2VNh"

interface NASAAPIInterface {

    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto(): PhotoResponse?
}