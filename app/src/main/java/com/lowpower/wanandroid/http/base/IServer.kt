package com.lowpower.wanandroid.http.base

import com.lowpower.wanandroid.ProjectBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.POST


interface IServer {

    @GET()
    fun login(): Observable<String>

    @GET()
    fun logOut(): Observable<String>

    @POST()
    fun register(userName: String, passWord: String): Observable<String>

    @GET("/project/tree/json")
    fun getProject(): Observable<ProjectBean>
}