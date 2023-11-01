package com.lowpower.wanandroid.http

import com.lowpower.wanandroid.http.base.IServer

class RetrofitHelper {
    companion object {
        fun getApiService(): IServer {
            return HttpApi.getApiService(IServer::class.java, "https://www.wanandroid.com")
        }
    }
}