package com.androidifygeeks.sample.viewmodel.data

import com.androidifygeeks.sample.util.extension.empty

/**
 * @author ashish on 12,December,2018
 */
data class Comment(val postId: Int, val id: Int, val name: String, val email: String, val body: String) {

    companion object {
        fun empty() = Comment(0, 0, String.empty(), String.empty(), String.empty())
    }

    fun toComment() = Comment(postId, id, name, email, body)
}