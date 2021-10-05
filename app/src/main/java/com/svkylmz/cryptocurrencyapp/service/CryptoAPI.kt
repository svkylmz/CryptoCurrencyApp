package com.svkylmz.cryptocurrencyapp.service

import com.svkylmz.cryptocurrencyapp.model.Crypto
import com.svkylmz.cryptocurrencyapp.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {
    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key: String
    ): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String,
        @Query("ids") id: String,
        @Query("attributes") attribute: String
    ): Crypto
}