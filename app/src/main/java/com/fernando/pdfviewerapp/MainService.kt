package com.fernando.pdfviewerapp

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

interface MainService {

    @GET
    @Streaming
    suspend fun downLoadFile(@Url url: String): Response<ResponseBody>


    companion object {
       private val clients = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS).build()
        fun buildRetrofit(): MainService =
            Retrofit
                .Builder()
                .baseUrl("https://google.com")
                .client(clients)
                .build()
                .create(MainService::class.java)
    }
}