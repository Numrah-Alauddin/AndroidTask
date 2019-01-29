package com.example.lenovo.a2ndtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Lenovo on 11/10/2018.
 */
class PostAdapter(context:Context,var postList:ArrayList<Post>) : ArrayAdapter<Post>(context,0,postList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var view=convertView

        if(convertView==null) {
            view = LayoutInflater.from(context).inflate(R.layout.homepost_layout, parent, false)
        }

        val postData=postList.get(position)

        val userImage=view?.findViewById<ImageView>(R.id.friend_img)
        val userName=view?.findViewById<TextView>(R.id.friend_name)
        val postTime=view?.findViewById<TextView>(R.id.post_time)
        val postText=view?.findViewById<TextView>(R.id.post_text)
        val postImage=view?.findViewById<ImageView>(R.id.post_image1)
        val likeCount=view?.findViewById<TextView>(R.id.like_count_text)
        val commCount=view?.findViewById<TextView>(R.id.comment_count)

        userImage?.setImageResource(postData.userImage)
        userName?.text=postData.userName
        postTime?.text=postData.postTime
        postText?.text=postData.postText
       // postImage?.setImageResource(postData.postImage)
        likeCount?.text=postData.likeCount.toString()
        commCount?.text=postData.commentCount.toString()

        return view
    }
}