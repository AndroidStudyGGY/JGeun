package com.jgeun.core.network

import com.jgeun.core.network.api.GithubService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

	private val okHttpClient = OkHttpClient.Builder()
		.connectTimeout(15, TimeUnit.SECONDS)
		.writeTimeout(20, TimeUnit.SECONDS)
		.readTimeout(15, TimeUnit.SECONDS)
		.addInterceptor(
			HttpLoggingInterceptor()
		)
		.build()

	private val json = Json {
		isLenient = true
		ignoreUnknownKeys = true
	}

	private val retrofit = Retrofit.Builder()
		.baseUrl("https://api.github.com/")
		.addConverterFactory(
			json.asConverterFactory("application/json; charset=UTF8".toMediaType())
		)
		.client(okHttpClient)
		.build()

	val gitHubService = retrofit.create(GithubService::class.java)
}