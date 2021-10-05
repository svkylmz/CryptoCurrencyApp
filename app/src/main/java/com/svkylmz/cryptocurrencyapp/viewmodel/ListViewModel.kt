package com.svkylmz.cryptocurrencyapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svkylmz.cryptocurrencyapp.model.CryptoListItem
import com.svkylmz.cryptocurrencyapp.repository.CryptoRepository
import com.svkylmz.cryptocurrencyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: CryptoRepository): ViewModel() {

    var cryptoList = mutableStateOf<List<CryptoListItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun loadCryptos() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getCryptoList()   // use viewModelScope.launch{} to use getCryptoList suspend function on CryptoRepository

            when(result) {
                is Resource.Success -> {
                    val cryptoItems = result.data!!.mapIndexed { index, item ->
                        CryptoListItem(item.currency, item.price)
                    }
                    errorMessage.value = ""
                    isLoading.value = false
                    cryptoList.value += cryptoItems
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
            }
        }
    }
}