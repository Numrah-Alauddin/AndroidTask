package com.example.lenovo.a2ndtask

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    companion object {
         var emailToPass:String=""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUp:Button=findViewById(R.id.signupBtn)
        val user_email:EditText=findViewById(R.id.emailEt)

        signUp.setOnClickListener({
            emailToPass=user_email.text.toString()
            val intent= Intent(this,Friends::class.java)
            startActivity(intent)
            finish()
        })
    }
}
