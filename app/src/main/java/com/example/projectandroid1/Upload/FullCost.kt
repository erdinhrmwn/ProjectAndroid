package com.example.projectandroid1.Upload

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.projectandroid1.R
import kotlinx.android.synthetic.main.upload_1.*


class FullCost : AppCompatActivity() {

    private val RESULT_GALLERY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_1)


        uploadImage1.setOnClickListener {
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, RESULT_GALLERY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_GALLERY && data != null){
            Toast.makeText(this, "Berhasil upload gambar", Toast.LENGTH_SHORT).show()
        }
    }
}