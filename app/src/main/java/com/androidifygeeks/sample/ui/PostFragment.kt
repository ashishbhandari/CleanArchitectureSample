package com.androidifygeeks.sample.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.androidifygeeks.sample.R
import com.androidifygeeks.sample.manager.NavigationManager
import com.androidifygeeks.sample.ui.adapter.PostAdapter
import com.androidifygeeks.sample.ui.util.CommonBaseFragment
import com.androidifygeeks.sample.util.exception.Failure
import com.androidifygeeks.sample.util.extension.failure
import com.androidifygeeks.sample.util.extension.observe
import com.androidifygeeks.sample.util.extension.viewModel
import com.androidifygeeks.sample.viewmodel.PostViewModel
import com.androidifygeeks.sample.viewmodel.data.PostView
import kotlinx.android.synthetic.main.fragment_post_layout.*
import javax.inject.Inject

/**
 * @author ashish on 11,December,2018
 */
class PostFragment : CommonBaseFragment() {


    override fun layoutId() = R.layout.fragment_post_layout

    private lateinit var postsViewModel: PostViewModel

    @Inject
    lateinit var postAdapter: PostAdapter
    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        postsViewModel = viewModel(viewModelFactory) {
            observe(posts, ::renderPostList)
            failure(failure, ::handleFailure)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadPosts()
    }

    private fun initView() {
        postList.layoutManager = LinearLayoutManager(activity)
        postList.adapter = postAdapter
        postAdapter.clickListener = { postView ->
            Toast.makeText(activity, "Item Clicked : " + postView.title, Toast.LENGTH_LONG).show()
            navigationManager.navigateToPostDetail(activity!!, postView)
        }

    }

    private fun loadPosts() {
        postsViewModel.loadPost()
    }

    private fun renderPostList(posts: List<PostView>?) {
        Toast.makeText(activity, "hello", Toast.LENGTH_LONG).show()
        postAdapter.collection = posts.orEmpty()
    }

    private fun handleFailure(failure: Failure?) {
        Toast.makeText(activity, "Its failure", Toast.LENGTH_LONG).show()
    }

}