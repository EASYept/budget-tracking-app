package ru.cashwriter.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class FillData : ViewModel() {

    val spender: MutableLiveData<String> by lazy {
       return@lazy MutableLiveData<String>()
    }


}