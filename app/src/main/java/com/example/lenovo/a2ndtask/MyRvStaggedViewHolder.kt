package com.example.lenovo.a2ndtask

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView

class MyRvStaggedViewHolder(myItem: View) : RecyclerView.ViewHolder(myItem) {
    val myIv : ImageView = myItem.findViewById(R.id.imageview_widget)
}
