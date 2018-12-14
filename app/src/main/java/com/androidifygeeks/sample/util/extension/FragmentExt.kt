package com.androidifygeeks.sample.util.extension

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.androidifygeeks.sample.ui.util.CommonBaseActivity
import com.androidifygeeks.sample.ui.util.CommonBaseFragment
import kotlinx.android.synthetic.main.activity_layout.*

/**
 * @author ashish on 11,December,2018
 */

/**
 * Common fragment inline transaction control
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()


/**
 * common inline viewModel provider
 */
inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}

fun CommonBaseFragment.close() = fragmentManager?.popBackStack()

val CommonBaseFragment.viewContainer: View get() = (activity as CommonBaseActivity).fragmentContainer