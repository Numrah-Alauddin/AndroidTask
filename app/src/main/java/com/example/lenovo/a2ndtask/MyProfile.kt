package com.example.lenovo.a2ndtask

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MyProfile : AppCompatActivity() {

    lateinit var userEt: EditText
    private val SELECT_PICTURE = 100
    private val CAPTURE_PICTURE = 100
    var photoFile: File? = null
    var mCurrentPhotoPath:String? = null
    lateinit var  profileImg: ImageView
    lateinit var   myBitmap: Bitmap

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        profileImg= findViewById(R.id.profile_img)
        val emailTv: TextView = findViewById(R.id.emailTv)
        val edit: EditText = findViewById(R.id.edit)
        val edit_btn: ImageView = findViewById(R.id.edit_btn)
        userEt = findViewById<EditText>(R.id.edit)

        emailTv.text = MainActivity.emailToPass
        val intent= intent
        profileImg.setImageResource(intent.getIntExtra("new_image",R.drawable.user_img3))


        edit_btn.setOnClickListener({

            edit.isEnabled = true
            edit.requestFocus()
            edit.isCursorVisible = true
            edit.setSelection(0, edit.text.length)
            edit.highlightColor = ContextCompat.getColor(this, android.R.color.darker_gray)

        })

        profileImg.setOnClickListener({

            //Gallery Intent
            /*val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            intent.type = "image*//*"
            intent.putExtra("crop","true")
            intent.putExtra("scale","true")
            intent.putExtra("return-data",true)
            startActivityForResult(Intent.createChooser(intent,"select Image"),SELECT_PICTURE)*/

            //Camera Intent
            /*val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAPTURE_PICTURE)*/

            //FileProvider Way
            //takePictureIntent()

            startActivity(Intent(this,SelectPhotos::class.java))
        })
    }

    private fun takePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->

            takePictureIntent.resolveActivity(packageManager)?.also {

                photoFile = try {
                    createImageFile()
                } catch (ex: IOException) {

                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                            this,
                            "$packageName.fileprovider",
                            it
                    )
                    Log.e("FILE_EXISTS", "${photoFile?.exists()}")
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, CAPTURE_PICTURE)
                }
            }
        }
    }


    private fun createImageFile(): File? {

        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val f = File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
        )
        mCurrentPhotoPath = f.absolutePath
        return f
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == CAPTURE_PICTURE){
            photoFile?.also {
                myBitmap = BitmapFactory.decodeFile(it.absolutePath)
                profileImg.setImageBitmap(myBitmap)
            }

        }
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //Gallery Result
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                val selectedImageUri = data?.data;
                if (null != selectedImageUri) {

                    profile_img.setImageURI(selectedImageUri);
                }
            }
        }

        //Camera Result
        if (resultCode == RESULT_OK) {
            val img=data?.extras?.get("data")
            profileImg.setImageBitmap(img as Bitmap)
        }
    }*/

    override fun onBackPressed() {

        val name=userEt.text.toString()
        val intent=Intent()

        val stream = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val bytes = stream.toByteArray()

        intent.putExtra("userName",name)
        intent.putExtra("bmp", bytes)

        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}

