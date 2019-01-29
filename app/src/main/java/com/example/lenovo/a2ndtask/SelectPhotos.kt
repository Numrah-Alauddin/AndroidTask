package com.example.lenovo.a2ndtask

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_select_photos.*


class SelectPhotos : AppCompatActivity() {

    private val SELECT_PICTURE = 101
    private val CAPTURE_PICTURE = 100
    val list= arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_photos)

        //Gallery Intent
        select_gallery.setOnClickListener({
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "select Image"), SELECT_PICTURE)
        })

        //Camera Intent
        select_camera.setOnClickListener({
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAPTURE_PICTURE)
        })

        list.add(R.drawable.user_profile_image)
        list.add(R.drawable.user_profile_image2)
        list.add(R.drawable.user_profile_image3)
        list.add(R.drawable.smiley)
        list.add(R.drawable.sample)
        list.add(R.drawable.sample1)
        list.add(R.drawable.sample2)
        list.add(R.drawable.sample3)

        select_rv_list.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        select_rv_list.adapter = MyRvStaggedAdapter(list, ::onItemClick)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //Gallery Result
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                val selectedImageUri = data?.data;
                if (null != selectedImageUri) {

                    //profile_img.setImageURI(selectedImageUri);
                }
            }
        }

        //Camera Result
        if (resultCode == RESULT_OK) {
            val img=data?.extras?.get("data")
            //profileImg.setImageBitmap(img as Bitmap)
        }
    }

    fun onItemClick(position: Int, holder: RecyclerView.ViewHolder) {
       // t("clicked on $position")
        val intent=Intent(this,MyProfile::class.java)
        intent.putExtra("new_image",list[position])
        startActivity(intent)
        finish()
    }
}
