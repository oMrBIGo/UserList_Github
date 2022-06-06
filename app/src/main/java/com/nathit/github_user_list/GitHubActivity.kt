package com.nathit.github_user_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nathit.github_user_list.Model.UserModel
import com.nathit.github_user_list.databinding.ActivityGitHubBinding
import com.nathit.github_user_list.databinding.ActivityMainBinding

class GitHubActivity : AppCompatActivity() {

    private val urlGithub = intent.getStringExtra("repos_url")
    private lateinit var binding: ActivityGitHubBinding
    var usersItem = arrayOf<UserModel>()
    val users = Users()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGitHubBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}