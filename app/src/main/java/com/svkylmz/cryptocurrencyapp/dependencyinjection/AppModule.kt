package com.svkylmz.cryptocurrencyapp.dependencyinjection

import com.svkylmz.cryptocurrencyapp.repository.CryptoRepository
import com.svkylmz.cryptocurrencyapp.service.CryptoAPI
import com.svkylmz.cryptocurrencyapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object AppModule {
    //Create and use retrofit api
    @Singleton
    @Provides
    fun provideCryptoApi(): CryptoAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CryptoAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideCryptoRepository(api: CryptoAPI) = CryptoRepository(api)
}