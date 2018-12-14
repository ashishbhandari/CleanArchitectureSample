package com.androidifygeeks.sample.viewmodel.data

import com.androidifygeeks.sample.util.extension.empty

/**
 * @author ashish on 12,December,2018
 */
data class Photo(val albumId: Int, val id: Int, val thumbnailUrl: String, val url: String) {

    companion object {
        fun empty() = Photo(0, 0, String.empty(), String.empty())
    }

    fun toPhoto() = Photo(albumId, id, thumbnailUrl, url)
}