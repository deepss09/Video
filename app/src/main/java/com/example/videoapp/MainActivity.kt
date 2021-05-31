package com.example.videoapp

import android.content.Context
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs


class MainActivity : AppCompatActivity() {

    var array = ArrayList<VideoModel>()
    var adapter: VideoAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        array.add(
            VideoModel(
                "Tree with flowers",
                "The branches of a tree wave in the breeze, with pointy leaves ",
                "https://assets.mixkit.co/videos/preview/mixkit-tree-with-yellow-flowers-1173-large.mp4"
            )
        )
        array.add(
            VideoModel(
                "multicolored lights",
                "A man with a small beard and mustache wearing a white sweater, sunglasses, and a backwards black baseball cap turns his head in different directions under changing colored lights.",
                "https://assets.mixkit.co/videos/preview/mixkit-man-under-multicolored-lights-1237-large.mp4"
            )
        )
        array.add(
            VideoModel(
                "holding neon light",
                "Bald man with a short beard wearing a large jean jacket holds a long tubular neon light thatch",
                "https://assets.mixkit.co/videos/preview/mixkit-man-holding-neon-light-1238-large.mp4"
            )
        )
        array.add(
            VideoModel(
                "Sun over hills",
                "The sun sets or rises over hills, a body of water beneath them.",
                "https://assets.mixkit.co/videos/preview/mixkit-sun-over-hills-1183-large.mp4"
            )
        )
        array.add(VideoModel("Woman petting a cat",
            "A woman sits in a yellow chair inside a home, petting a black cat that sits on her lap.",
            "https://assets.mixkit.co/videos/preview/mixkit-woman-petting-a-cat-1542-large.mp4"))

        adapter = VideoAdapter(array)
        viewPager.adapter = adapter
    }
}