package com.lowpower.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.lowpower.wanandroid.http.DefaultObserver
import com.lowpower.wanandroid.http.HttpApi
import com.lowpower.wanandroid.http.RetrofitHelper
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.stream.Collectors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        RetrofitHelper.getApiService()
//            .getProject()
//            .enqueue(object : Callback<String> {
//                override fun onResponse(
//                    call: Call<String>?,
//                    response: Response<String>?
//                ) {
//                    Log.w("demo", "MainActivity onResponse ${response?.body().toString()}")
//                }
//
//                override fun onFailure(call: Call<String>?, t: Throwable?) {
//                    Log.w("demo", "MainActivity onFailure ${Log.getStackTraceString(t)}")
//
//                }
//
//            })

        RetrofitHelper
            .getApiService()
            .getProject()
            .flatMapIterable {
                Log.w("demo", "MainActivity flatMapIterable size = ${it.data.size}")
                return@flatMapIterable it.data
            }.filter {
                //对数据进行过滤
                return@filter it.name.length > 3
            }.toList()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DefaultObserver<List<Data>>() {
                override fun onSuccess(response: List<Data>) {
                    Log.w("demo", "MainActivity onSuccess data size = ${response.size}")
                }

                override fun onFila(message: String?) {

                }

                override fun onFinish() {

                }

                override fun onException(msg: String?) {

                }

            })
    }

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        Log.w("demo", "keyCode  = ${event?.keyCode}")
        return super.dispatchKeyEvent(event)
    }
}
