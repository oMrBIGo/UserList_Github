package com.nathit.github_user_list.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.nathit.github_user_list.Adapter.UserAdapter
import com.nathit.github_user_list.Array.Users
import com.nathit.github_user_list.Model.UserModel
import com.nathit.github_user_list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val url = "https://api.github.com/users"
    private lateinit var binding: ActivityMainBinding
    var usersItem = arrayOf<UserModel>()
    val users = Users()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stringRequest = StringRequest(url, {
            val gsonBuilder = GsonBuilder()
            val gson = gsonBuilder.create()
            usersItem = gson.fromJson(it,Array<UserModel>::class.java)
            usersItem.forEach {
                users.add(it)
            }
            val adapter = UserAdapter(this,users)
            binding.rv.layoutManager = LinearLayoutManager(this)
            binding.rv.adapter = adapter
        }, {
            Toast.makeText(applicationContext, "Error: $it",Toast.LENGTH_SHORT).show()
        })
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }


}