package com.example.lenovo.a2ndtask

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Lenovo on 11/15/2018.
 */
class MyRvStaggedAdapter( val data:ArrayList<Int>, val onItemClick:(Int, RecyclerView.ViewHolder)->Unit)
    : RecyclerView.Adapter<MyRvStaggedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRvStaggedViewHolder {

        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.pintrest_item,parent,false)
        return MyRvStaggedViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyRvStaggedViewHolder, position: Int) {

        holder.myIv.setImageResource(data[position])
        holder.itemView.setOnClickListener {
            onItemClick(position,holder)
        }
    }
}