package com.nathit.github_user_list.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathit.github_user_list.Array.Githubs
import com.nathit.github_user_list.R
import java.text.SimpleDateFormat

class GithubAdapter(val context: Context, val githubs: Githubs) :
    RecyclerView.Adapter<GithubAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubAdapter.MyHolder {
        ///TODO("onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.github_profile, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: GithubAdapter.MyHolder, position: Int) {
        ///TODO("onBindViewHolder")

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm a")

        val output_created_at : String = formatter.format(parser.parse(githubs[position].created_at))
        val output_updated_at : String = formatter.format(parser.parse(githubs[position].updated_at))
        val output_pushed_at : String = formatter.format(parser.parse(githubs[position].pushed_at))

        holder.nameTv.text = githubs[position].name
        holder.descriptionTv.text = githubs[position].description
        holder.languageTv.text = githubs[position].language
        holder.createTv.text = output_created_at
        holder.updateTv.text = output_updated_at
        holder.pushedTv.text = output_pushed_at
        holder.starTv.text = githubs[position].stargazers_count
        holder.forkTv.text = githubs[position].forks_count
        holder.visibilityTv.text = githubs[position].visibility

        holder.click_to_github.setOnClickListener {
            val urlGithub = githubs[position].html_url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(urlGithub)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        ///TODO("getItemCount")
        return githubs.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTv: TextView = itemView.findViewById<View>(R.id.nameTv) as TextView
        var descriptionTv: TextView = itemView.findViewById<View>(R.id.descriptionTv) as TextView
        var languageTv: TextView = itemView.findViewById<View>(R.id.languageTv) as TextView
        var createTv: TextView = itemView.findViewById<View>(R.id.createTv) as TextView
        var updateTv: TextView = itemView.findViewById<View>(R.id.updateTv) as TextView
        var pushedTv: TextView = itemView.findViewById<View>(R.id.pushedTv) as TextView
        var starTv: TextView = itemView.findViewById<View>(R.id.starTv) as TextView
        var forkTv: TextView = itemView.findViewById<View>(R.id.forkTv) as TextView
        var visibilityTv: TextView = itemView.findViewById<View>(R.id.visibilityTv) as TextView
        var click_to_github: Button = itemView.findViewById<View>(R.id.click_to_github) as Button
    }

}