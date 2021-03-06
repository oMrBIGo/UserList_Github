package com.nathit.github_user_list.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathit.github_user_list.Activity.GitHubActivity
import com.nathit.github_user_list.R
import com.nathit.github_user_list.Array.Users
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(val context: Context, val users: Users) :
    RecyclerView.Adapter<UserAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyHolder {
        ///TODO("onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyHolder, position: Int) {
        ///TODO("onBindViewHolder")
        Picasso.get().load(users[position].avatar_url).placeholder(R.drawable.loading).into(holder.avatarIm)
        holder.loginTv.text = users[position].login
        holder.html_url_tv.text = users[position].repos_url
        holder.typeTv.text = users[position].type
        holder.idTv.text = "ID:" + users[position].id.toString()

        holder.html_url_tv.setOnClickListener {
            val urlGithub = users[position].repos_url
            val intent = Intent(context, GitHubActivity::class.java)
            intent.putExtra("repos_url",urlGithub)
            intent.putExtra("username", users[position].login)
            context.startActivity(intent)
        }

        holder.githubBtn.setOnClickListener {
            val urlGithub = users[position].repos_url
            val intent = Intent(context, GitHubActivity::class.java)
            intent.putExtra("repos_url",urlGithub)
            intent.putExtra("username", users[position].login)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        ///TODO("getItemCount")
        return users.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        ///TODO("MyHolder")
        var avatarIm: CircleImageView = itemView.findViewById<View>(R.id.avatarIm) as CircleImageView
        var loginTv: TextView = itemView.findViewById<View>(R.id.loginTv) as TextView
        var html_url_tv: TextView = itemView.findViewById<View>(R.id.html_url_tv) as TextView
        var githubBtn: Button = itemView.findViewById(R.id.githubBtn) as Button
        var typeTv: TextView = itemView.findViewById(R.id.typeTv) as TextView
        var idTv: TextView = itemView.findViewById(R.id.idTv) as TextView


    }

}