package com.nathit.github_user_list.Model

data class UserModel(
    val avatar_url: String,     //uses image profile
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,          //uses login username
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,      //uses repos url
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
)