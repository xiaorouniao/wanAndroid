package com.lowpower.wanandroid.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class RetrofitUtils {
    companion object {
        private fun getOkHttpClientBuilder(): OkHttpClient.Builder {

            return OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(8000, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpInterceptor())
//                .addNetworkInterceptor(NetWorkInterceptor())
//                .addInterceptor()
        }

        fun getRetrofitBuilder(baseUrl: String): Retrofit.Builder {
            val client = getOkHttpClientBuilder().build();
            return Retrofit.Builder()
                .client(client)
//                .addConverterFactory(CustomGsonConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
        }
    }
}