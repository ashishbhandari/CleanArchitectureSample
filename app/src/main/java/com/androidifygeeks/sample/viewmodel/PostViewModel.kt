package com.androidifygeeks.sample.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.androidifygeeks.sample.viewmodel.data.Post
import com.androidifygeeks.sample.viewmodel.data.PostFetcher
import com.androidifygeeks.sample.viewmodel.data.PostView
import com.androidifygeeks.sample.viewmodel.data.UseCase
import javax.inject.Inject

/**
 * @author ashish on 11,December,2018
 */
class PostViewModel @Inject constructor(private val postFetcher: PostFetcher) : BaseViewModel() {

    var posts: MutableLiveData<List<PostView>> = MutableLiveData()

    fun loadPost() = postFetcher(UseCase.None()) {
        it.either(::handleFailure, ::handlePostList)
    }

    private fun handlePostList(posts: List<Post>) {
        this.posts.value = posts.map { PostView(it.userId, it.id, it.title, it.body) }
    }
}