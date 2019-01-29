package com.example.lenovo.a2ndtask

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {

    private val SELECT_PICTURE = 100
    var status: Boolean = false
    val postList = ArrayList<Post>()
    lateinit var post_text: String
    lateinit var post_img: Bitmap
    var selectedImageUri: Uri? = null
    lateinit var postAdapter: PostRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val shareBtn = findViewById<TextView>(R.id.share_btn2)
        val postImage = findViewById<ImageView>(R.id.post_image)
        val post_url = findViewById<TextView>(R.id.post_url)

        //post_url.movementMethod=LinkMovementMethod.getInstance()

        /* post_url.setOnClickListener({

             val uri=Uri.parse("https://www.google.com/maps/search/?api=1&query=+Usman+Institute+of+Technology")
             val intent=Intent(Intent.ACTION_VIEW,uri)
             startActivity(intent)
         })*/

        //1st correct way
        /*  val imagePath = Environment.getExternalStorageDirectory().toString() + "/Pictures/Images/myImage.jpg"
          val imageFileToShare = File(imagePath)
          val uri = Uri.fromFile(imageFileToShare)*/

        /* val bm = (postImage.drawable as BitmapDrawable).bitmap
         val bytes = ByteArrayOutputStream()
         bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes)

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
             requestPermissions(arrayOf(
                     Manifest.permission.WRITE_EXTERNAL_STORAGE
             ), 2)
         }

         val file = File(Environment.getExternalStorageDirectory().absolutePath.toString() + "/Pictures/Images/abc.jpg")
         file.createNewFile()
         val fos = FileOutputStream(file)
         fos.write(bytes.toByteArray())

         shareBtn.setOnClickListener {

             val text=post_url.text
             val intent = Intent(Intent.ACTION_SEND)
             intent.type = "image*//*"
            intent.putExtra("crop", "true")
            intent.putExtra("scale", "true")
            intent.putExtra("return-data", true)
            intent.putExtra(Intent.EXTRA_TEXT,text)
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(Intent.createChooser(intent, "Share Image"))

        }*/

        //ListView
        /* var postArray=ArrayList<Post>()

         postArray.add(Post("John Smith",R.drawable.user_ic,"Hello Friends","Just Now",R.drawable.practice,5,10))
         postArray.add(Post("John Smith",R.drawable.user_ic,"Hello Friends","Just Now",R.drawable.practice,5,10))
         postArray.add(Post("John Smith",R.drawable.user_ic,"Hello Friends","Just Now",R.drawable.practice,5,10))

         var adapter=PostAdapter(this,postArray)

         postList.adapter=adapter*/


        val uri = Uri.parse("android.resource://com.example.lenovo.a2ndtask/drawable/practice")
        val uri1 = Uri.parse("android.resource://com.example.lenovo.a2ndtask/drawable/user_profile_image3")
        val uri2 = Uri.parse("android.resource://com.example.lenovo.a2ndtask/drawable/weather")

        //RecyclerView
        postList.add(Post("Mr John", R.drawable.user_profile_image2, "Do Practice!!", "1 day ago",
                uri, 3, 6))
        postList.add(Post("Ahmed Ali", R.drawable.user_profile_image3, "I am what ,I am !!", "1 day ago",
                uri1, 3, 6))
        postList.add(Post("Sara Khan", R.drawable.user_profile_image, "Lovely weather", "1 day ago",
                uri2, 3, 6))


        postAdapter = PostRvAdapter(this, postList)
        post_list2.layoutManager = LinearLayoutManager(this)
        post_list2.adapter = postAdapter

        post_list2.smoothScrollToPosition(0)
//
        //getting input
        home_share_btn.setOnClickListener({
            post_text = home_post_et.text.toString()

            if (selectedImageUri != null) {
                postList.add(0, Post("John Smith", R.drawable.user_img3, post_text, "Just Now",
                        selectedImageUri!!, 0, 0))
                postAdapter.notifyDataSetChanged()
                home_post_et.text.clear()
                home_share_photo.visibility=View.GONE
            } else {

                postList.add(0, Post("John Smith", R.drawable.user_img3, post_text, "Just Now",
                        null, 0, 0))
                postAdapter.notifyDataSetChanged()
                home_post_et.text.clear()
                home_share_photo.visibility=View.GONE
            }
        })

        //add photo Gallery Intent
        home_photos.setOnClickListener({
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            intent.type = "image/*"
            /*intent.putExtra("crop", "true")
            intent.putExtra("scale", "true")
            intent.putExtra("return-data", true)*/
            startActivityForResult(Intent.createChooser(intent, "select Image"), SELECT_PICTURE)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //Gallery Result
        if (requestCode == SELECT_PICTURE) {
            if (resultCode == Activity.RESULT_OK) {
                selectedImageUri = data?.data;
                if (null != selectedImageUri) {
                    Toast.makeText(this, "ashdb", Toast.LENGTH_LONG).show()
                    home_share_photo.visibility = View.VISIBLE
                    home_share_photo.setImageURI(selectedImageUri);
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (status)
            Toast.makeText(this, "Welcome Back", Toast.LENGTH_LONG).show()
        status = false
    }

    override fun onStop() {
        super.onStop()
        status = true
    }
}
