package com.example.lenovo.a2ndtask

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Lenovo on 11/16/2018.
 */
class PostRvViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val friendImg=itemView?.findViewById<ImageView>(R.id.friend_img)
    val friendName=itemView?.findViewById<TextView>(R.id.friend_name)
    val postTime=itemView?.findViewById<TextView>(R.id.post_time)
    val postText=itemView?.findViewById<TextView>(R.id.post_text)
    val postImg=itemView?.findViewById<ImageView>(R.id.post_image1)
    val likeCount=itemView?.findViewById<ImageView>(R.id.like_count)
    val like_count_text=itemView?.findViewById<TextView>(R.id.like_count_text)
    val commentCount=itemView?.findViewById<TextView>(R.id.comment_count)
    val shareBtn=itemView?.findViewById<TextView>(R.id.share_btn)
}