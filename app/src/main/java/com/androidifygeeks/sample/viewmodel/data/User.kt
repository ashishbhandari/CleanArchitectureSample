package com.androidifygeeks.sample.viewmodel.data

import com.androidifygeeks.sample.util.extension.empty

/**
 * @author ashish on 12,December,2018
 */
data class User(val id: Int, val name: String, val username: String, val email: String) {

    companion object {
        fun empty() = User(0, String.empty(), String.empty(), String.empty())
    }

    fun toUser() = User(id, name, username, email)
}