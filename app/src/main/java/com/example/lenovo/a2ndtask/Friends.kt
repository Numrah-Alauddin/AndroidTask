package com.example.lenovo.a2ndtask

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView



class Friends : AppCompatActivity() {

    val PROFILE_INTENT_KEY=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        val profileIntent: ImageView = findViewById(R.id.profile_img)
        val homeIntent: ImageView = findViewById(R.id.home_image)

        profileIntent.setOnClickListener({
            val intent=Intent(this,MyProfile::class.java)
            startActivityForResult(intent,PROFILE_INTENT_KEY)
        })
        homeIntent.setOnClickListener({
            startActivity(Intent(this, Home::class.java))
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==PROFILE_INTENT_KEY){
            if(resultCode== Activity.RESULT_OK){
                findViewById<TextView>(R.id.username_friendspage).setText(data?.getStringExtra("userName"))

                val bytes = data?.getByteArrayExtra("bmp")
                if(bytes!=null) {
                    val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    findViewById<ImageView>(R.id.user_icon_img).setImageBitmap(bmp)
                }
            }
        }
    }
}
