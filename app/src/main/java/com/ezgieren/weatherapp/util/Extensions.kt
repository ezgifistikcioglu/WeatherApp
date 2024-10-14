package com.ezgieren.weatherapp.util

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}
// LiveData callback functions
fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>