package com.nathit.github_user_list.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathit.github_user_list.GitHubActivity
import com.nathit.github_user_list.Githubs
import com.nathit.github_user_list.Model.UserModel
import com.nathit.github_user_list.R
import com.nathit.github_user_list.Users
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class GithubAdapter(val context: Context, val githubs: Githubs) :
    RecyclerView.Adapter<GithubAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubAdapter.MyHolder {
        ///TODO("onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.github_profile, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: GithubAdapter.MyHolder, position: Int) {
        ///TODO("onBindViewHolder")
        Picasso.get().load(githubs[position].avatar_url).placeholder(R.drawable.loading).into(holder.avatarIm)
        holder.loginTv.text = githubs[position].login
        holder.html_url_tv.text = githubs[position].repos_url

    }

    override fun getItemCount(): Int {
        ///TODO("getItemCount")
        return githubs.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatarIm: CircleImageView = itemView.findViewById<View>(R.id.avatarIm) as CircleImageView
        var loginTv: TextView = itemView.findViewById<View>(R.id.loginTv) as TextView
        var html_url_tv: TextView = itemView.findViewById<View>(R.id.html_url_tv) as TextView


    }

}