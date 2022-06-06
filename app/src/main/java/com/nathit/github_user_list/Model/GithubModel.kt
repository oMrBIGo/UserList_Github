package com.nathit.github_user_list.Model

data class GithubModel(
    val name: String,     //uses image profile
    val full_name: String,
    val description: String,
    val html_url: String,
    val created_at: String,
    val updated_at: String,
    val pushed_at: String,
    val language: String,
    val stargazers_count: String
)