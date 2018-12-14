package com.androidifygeeks.sample.ui

import android.content.Context
import android.content.Intent
import com.androidifygeeks.sample.ui.util.CommonBaseActivity
import com.androidifygeeks.sample.viewmodel.data.PostView

/**
 * @author ashish on 12,December,2018
 */
class PostDetailActivity : CommonBaseActivity() {

    companion object {
        private const val PARAM_POST = "param_post"

        fun callingIntent(context: Context, postView: PostView): Intent {
            val intent = Intent(context, PostDetailActivity::class.java)
            intent.putExtra(PARAM_POST, postView)
            return intent
        }
    }

    override fun fragment() = PostDetailFragment.forPost(intent.getParcelableExtra(PARAM_POST))

}