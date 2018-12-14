package com.androidifygeeks.sample.manager

import android.content.Context
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.FragmentActivity
import android.widget.ImageView
import com.androidifygeeks.sample.ui.PostActivity
import com.androidifygeeks.sample.ui.PostDetailActivity
import com.androidifygeeks.sample.viewmodel.data.PostView
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author ashish on 10,December,2018
 */
@Singleton
class NavigationManager @Inject constructor() {

    fun navigateToMain(context: Context) {
        loadPost(context)
    }

    private fun loadPost(context: Context) = context.startActivity(PostActivity.callingIntent(context))

    fun navigateToPostDetail(activity: FragmentActivity, postView: PostView) {
        val intent = PostDetailActivity.callingIntent(activity, postView)
        activity.startActivity(intent)
    }
}