package com.androidifygeeks.sample.viewmodel.data

import com.androidifygeeks.sample.util.extension.empty

/**
 * @author ashish on 11,December,2018
 */
data class Post(val userId: Int, val id: Int, val title: String, val body: String) {

    companion object {
        fun empty() = Post(0, 0, String.empty(), String.empty())
    }

    fun toPost() = Post(userId, id, title, body)
}