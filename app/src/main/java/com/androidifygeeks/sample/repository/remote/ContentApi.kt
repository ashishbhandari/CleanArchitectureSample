package com.androidifygeeks.sample.repository.remote

import com.androidifygeeks.sample.viewmodel.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author ashish on 12,December,2018
 */
interface ContentApi {

    companion object {
        private const val PARAM_USER_ID = "userId"
        private const val PARAM_POST_ID = "postId"
        private const val PARAM_ALBUM_ID = "albumId"
        private const val POST = "posts"
        private const val USER = "users/{$PARAM_USER_ID}"
        private const val COMMENTS = "comments"
        private const val ALBUMS = "albums"
        private const val PHOTOS = "photos"
    }

    @GET(POST)
    fun posts(): Call<List<Post>>

    @GET(USER)
    fun user(@Path(PARAM_USER_ID) userId: Int): Call<User>

    @GET(COMMENTS)
    fun comments(@Query(PARAM_POST_ID) postId: Int): Call<List<Comment>>

    @GET(ALBUMS)
    fun albums(@Query(PARAM_USER_ID) userId: Int): Call<List<Album>>

    @GET(PHOTOS)
    fun photos(@Query(PARAM_ALBUM_ID) albumId: Int): Call<List<Photo>>
}