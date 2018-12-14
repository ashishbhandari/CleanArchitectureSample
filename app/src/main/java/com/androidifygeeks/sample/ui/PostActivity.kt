package com.androidifygeeks.sample.ui

import android.content.Context
import android.content.Intent
import com.androidifygeeks.sample.ui.util.CommonBaseActivity

/**
 * @author ashish on 10,December,2018
 */
class PostActivity : CommonBaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, PostActivity::class.java)
    }

    override fun fragment() = PostFragment()

}
