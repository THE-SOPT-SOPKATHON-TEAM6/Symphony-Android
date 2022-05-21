package org.sopt.symphony.data

import okhttp3.OkHttpClient
import org.sopt.symphony.data.service.SymphonyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private const val BASE_URL = ""

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    private var instance: SymphonyService? = null

    fun getInstance(): SymphonyService {
        return instance ?: synchronized(this) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create<SymphonyService>()
                .also { instance = it }
        }
    }
}
