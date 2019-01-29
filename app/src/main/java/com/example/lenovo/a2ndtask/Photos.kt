package com.example.lenovo.a2ndtask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView

class Photos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        /*myRecyclerList.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        myRecyclerList.adapter = MyRvStaggedAdapter(arrayListOf(
                R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6
        ),::onItemClick)*/

    }

    fun onItemClick(position:Int,holder: RecyclerView.ViewHolder){
        t("clicked on $position")
    }
}
