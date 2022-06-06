package com.nathit.github_user_list

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.nathit.github_user_list.Adapter.GithubAdapter
import com.nathit.github_user_list.Model.GithubModel
import com.nathit.github_user_list.databinding.ActivityGitHubBinding


class GitHubActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGitHubBinding
    var gitHubsItem = arrayOf<GithubModel>()
    val githubs = Githubs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGitHubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val urlGithub = intent.getStringExtra("repos_url")

        val stringRequest = StringRequest(urlGithub, {
            val gsonBuilder = GsonBuilder()
            val gson = gsonBuilder.create()
            gitHubsItem = gson.fromJson(it,Array<GithubModel>::class.java)
            gitHubsItem.forEach {
                Githubs.add(it)
            }
            val adapter = GithubAdapter(this,githubs)
            binding.rv.layoutManager = LinearLayoutManager(this)
            binding.rv.adapter = adapter
        }, {
            Toast.makeText(applicationContext, "Error: $it", Toast.LENGTH_SHORT).show()
        })
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }
}