package com.lowpower.wanandroid.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        Log.w("demo", "intercept....${chain?.request()?.url()?.toString()}")
        return chain?.proceed(chain?.request())
    }
}