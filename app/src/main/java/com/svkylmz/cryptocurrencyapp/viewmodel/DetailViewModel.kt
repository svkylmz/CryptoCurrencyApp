package com.svkylmz.cryptocurrencyapp.viewmodel

import androidx.lifecycle.ViewModel
import com.svkylmz.cryptocurrencyapp.model.Crypto
import com.svkylmz.cryptocurrencyapp.repository.CryptoRepository
import com.svkylmz.cryptocurrencyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: CryptoRepository): ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }
}