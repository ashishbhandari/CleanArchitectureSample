package com.androidifygeeks.sample.viewmodel.data

import com.androidifygeeks.sample.util.extension.empty

/**
 * @author ashish on 12,December,2018
 */
data class Album(val userId: Int, val id: Int, val title: String) {

    companion object {
        fun empty() = Album(0, 0, String.empty())
    }

    fun toAlbum() = Album(userId, id, title)
}