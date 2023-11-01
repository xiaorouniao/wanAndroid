package com.lowpower.wanandroid.http

class HttpApi {
    companion object {
        fun <T> getApiService(clazz: Class<T>, baseUrl: String): T {
            val build = RetrofitUtils.getRetrofitBuilder(baseUrl).build();
            return build.create(clazz)
        }
    }
}