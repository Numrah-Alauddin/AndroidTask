package com.example.lenovo.a2ndtask

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Lenovo on 11/16/2018.
 */
class PostRvAdapter(val context: Context, val postList: ArrayList<Post>) : RecyclerView.Adapter<PostRvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostRvViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.homepost_layout, parent, false)
        return PostRvViewHolder(view)
    }

    override fun getItemCount(): Int {

        return postList.count()
    }

    override fun onBindViewHolder(holder: PostRvViewHolder, position: Int) {

        var postData = postList[position]
        holder.friendImg?.setImageResource(postData.userImage)
        holder.friendName?.text = postData.userName
        holder.postTime?.text = postData.postTime
        holder.postText?.text = postData.postText
        holder.like_count_text?.text=postData.likeCount.toString()
        holder.commentCount?.text=postData.commentCount.toString()

        if(postData.postImage==null){
            holder.postImg?.visibility=View.GONE
        }
        else{
            holder.postImg?.visibility=View.VISIBLE
            holder.postImg?.setImageURI(postData.postImage)
        }



    }
}