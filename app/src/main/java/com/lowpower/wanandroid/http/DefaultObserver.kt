package com.lowpower.wanandroid.http

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class DefaultObserver<T> : Observer<T> {
    companion object {
        val TAG: String = "demo" + this.javaClass.name
    }

    override fun onSubscribe(d: Disposable) {
        Log.w(TAG, "onSubscribe......")
    }

    override fun onNext(t: T) {
        Log.w(TAG, "onNext......")
        onSuccess(t)
        onFinish()
    }

    override fun onError(e: Throwable) {
        Log.w(TAG, "onError......${Log.getStackTraceString(e)}")

        onException(e.message)
        onFinish()
    }

    override fun onComplete() {
        Log.w(TAG, "onComplete......")
    }


    abstract fun onSuccess(response: T)

    abstract fun onFila(message: String?)

    abstract fun onFinish()

    abstract fun onException(msg: String?)
}