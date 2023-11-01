package com.lowpower.wanandroid.http

import android.util.Log
import com.google.gson.Gson
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.BufferedReader
import java.lang.StringBuilder
import java.lang.reflect.Type

class CustomGsonConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type?,
        annotations: Array<out Annotation>?,
        retrofit: Retrofit?
    ): Converter<ResponseBody, *> {
        return CustomGsonResponseBodyConverter()
    }

    override fun requestBodyConverter(
        type: Type?,
        parameterAnnotations: Array<out Annotation>?,
        methodAnnotations: Array<out Annotation>?,
        retrofit: Retrofit?
    ): Converter<*, RequestBody> {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    override fun stringConverter(
        type: Type?,
        annotations: Array<out Annotation>?,
        retrofit: Retrofit?
    ): Converter<*, String> {
        return super.stringConverter(type, annotations, retrofit)
    }

    class CustomGsonResponseBodyConverter : Converter<ResponseBody, String> {
        override fun convert(value: ResponseBody?): String? {
            val charStream = value?.charStream()
            val bufferedReader = BufferedReader(charStream)
            val buffer = StringBuilder()
            var line = bufferedReader.readLine()
            while (line != null) {
                Log.w("demo", "json = $line")
                buffer.append(line)
                line = bufferedReader.readLine()
            }
            return buffer.toString()
        }
    }
}