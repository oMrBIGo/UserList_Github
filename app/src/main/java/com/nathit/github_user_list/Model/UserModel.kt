package com.nathit.github_user_list.Model

data class UserModel(
    val avatar_url: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val repos_url: String,
    val type: String,
    val url: String
)