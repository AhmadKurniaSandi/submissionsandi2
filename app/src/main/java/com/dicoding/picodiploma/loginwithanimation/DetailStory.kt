package com.dicoding.picodiploma.loginwithanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivityDetailStoryBinding

class DetailStory : AppCompatActivity() {
    private lateinit var binding: ActivityDetailStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val detailName = intent.getStringExtra(DETAIL_NAME)
        val detailDeksripsi = intent.getStringExtra(DETAIL_DESKRIPSI)
        val detailPhoto = intent.getStringExtra(DETAIL_PHOTO)

        binding.apply {
            namaDetail.text = detailName
            tvDescription.text = detailDeksripsi
            Glide.with(this@DetailStory)
                .load(detailPhoto)
                .into(ImageView)
        }


    }

    companion object {
        const val DETAIL_NAME = "detail_name"
        const val DETAIL_DESKRIPSI = "detail_deskripsi"
        const val DETAIL_PHOTO = "detail_photo"
    }
}