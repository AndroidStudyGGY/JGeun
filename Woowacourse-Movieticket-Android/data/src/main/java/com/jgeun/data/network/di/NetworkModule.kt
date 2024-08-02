package com.jgeun.data.network.di

import com.jgeun.data.BuildConfig
import com.jgeun.data.network.api.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun providesJson() = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun providesOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        )
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        json: Json
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/")
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesMovieService(
        retrofit: Retrofit
    ) : MovieService = retrofit.create(MovieService::class.java)
}