package com.emreakcadag.koindependencyinjection.di

import com.emreakcadag.koindependencyinjection.network.NASAAPIInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Emre Akçadağ on 3.06.2020
 *
 */
val networkModule = module {

    // https://api.nasa.gov/planetary/apod?api_key=SzVivPLHN7PCYZKtD3PupYZWeKPGTVS0Tx9F2VNh
    single(named("BASE_URL")) { "https://api.nasa.gov/plantary/" }

    single {
        val interceptor = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    single {
        val client = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            client.addInterceptor(get<HttpLoggingInterceptor>())
        }

        client.build()
    }

    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder().baseUrl(get<String>(named("BASE_URL")))
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(NASAAPIInterface::class.java)
    }
}

/*val coroutines = module {
    single(named("Background")) { Dispatchers.Default }
    single(named("IO")) { Dispatchers.IO }
    single(named("UI")) { Dispatchers.Main }

    factory(named("name")){

    }
}*/
