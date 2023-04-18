package com.zahrahosseini.motrack.core.data.common

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class  HeaderInterceptor @Inject constructor(
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val chainBuilder = chain.request().newBuilder()
        chainBuilder.addHeader("content-type", "application/json")

        return chain.proceed(chainBuilder.build())
    }
}