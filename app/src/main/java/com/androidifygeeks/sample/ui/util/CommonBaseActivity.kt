package com.androidifygeeks.sample.ui.util

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidifygeeks.sample.R
import com.androidifygeeks.sample.util.extension.inTransaction
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @author ashish on 10,December,2018
 */
abstract class CommonBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as CommonBaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment())
        }

    abstract fun fragment(): CommonBaseFragment
}