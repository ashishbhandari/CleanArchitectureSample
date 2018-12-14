package com.androidifygeeks.sample.util.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * @author ashish on 12,December,2018
 */

val Context.networkInfo: NetworkInfo? get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo