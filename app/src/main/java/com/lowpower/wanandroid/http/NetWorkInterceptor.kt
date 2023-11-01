package com.lowpower.wanandroid.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class NetWorkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        val response = chain?.proceed(chain?.request())
        return response
    }
}