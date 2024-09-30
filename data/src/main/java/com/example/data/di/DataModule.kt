package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.source.remote.MovieService
import com.example.data.util.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .client(
                OkHttpClient
                    .Builder()
                    .addNetworkInterceptor(AuthInterceptor(BuildConfig.API_KEY))
                    .build()
            )
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(
            MovieService::class.java,
        )
    }

}

