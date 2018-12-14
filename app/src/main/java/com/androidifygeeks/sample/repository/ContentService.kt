package com.androidifygeeks.sample.repository

import com.androidifygeeks.sample.repository.remote.ContentApi
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * @author ashish on 12,December,2018
 */
class ContentService @Inject constructor(retrofit: Retrofit) : ContentApi {

    private val contentApi by lazy { retrofit.create(ContentApi::class.java) }

    override fun posts() = contentApi.posts()

    override fun user(userId: Int) = contentApi.user(userId)

    override fun comments(postId: Int) = contentApi.comments(postId)

    override fun albums(userId: Int) = contentApi.albums(userId)

    override fun photos(albumId: Int) = contentApi.photos(albumId)

}