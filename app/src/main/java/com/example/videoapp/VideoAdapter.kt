package com.example.videoapp

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

    class VideoAdapter(arrVideo:ArrayList<VideoModel>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

        var arrVideoModel:ArrayList<VideoModel> = arrVideo

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
            return VideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
        }

        override fun getItemCount(): Int {
            return arrVideoModel.size
        }
        override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
            holder.setVideoData(arrVideoModel[position])
        }
     class VideoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun setVideoData(videoModel: VideoModel){
            itemView.title.text = videoModel.VideoTItle
            itemView.desc.text = videoModel.desc
            itemView.video.setVideoPath(videoModel.VideoUrl)
            itemView.video.setOnPreparedListener(object :MediaPlayer.OnPreparedListener{
                override fun onPrepared(mp: MediaPlayer?) {
                    itemView.progress_bar.visibility = View.GONE
                    if (mp != null) {
                        mp.start()
                    }
                    val videoRatio = mp?.videoWidth!!.toFloat()  / mp?.videoHeight.toFloat()
                    val screenRatio = itemView.video.width.toFloat() / itemView.video.height.toFloat()

                    val scale = videoRatio / screenRatio
                    if (scale > 1f){
                        itemView.video.scaleX = scale
                    }else{
                        itemView.video.scaleY = (1f / scale)
                    }
                }

            })

            itemView.video.setOnCompletionListener { object : MediaPlayer.OnCompletionListener{
                override fun onCompletion(mp: MediaPlayer) {
                    mp.start()
                }
            } }

        }

    }

}