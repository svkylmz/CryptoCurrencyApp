package com.svkylmz.cryptocurrencyapp.repository

import com.svkylmz.cryptocurrencyapp.model.Crypto
import com.svkylmz.cryptocurrencyapp.model.CryptoList
import com.svkylmz.cryptocurrencyapp.service.CryptoAPI
import com.svkylmz.cryptocurrencyapp.util.Constants.API_KEY
import com.svkylmz.cryptocurrencyapp.util.Constants.CALL_ATTRIBUTES
import com.svkylmz.cryptocurrencyapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(private val api: CryptoAPI) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch (e: Exception) {
            return Resource.Error("Error..")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY, id, CALL_ATTRIBUTES)
        } catch (e: Exception) {
            return Resource.Error("Error..")
        }
        return Resource.Success(response)
    }
}