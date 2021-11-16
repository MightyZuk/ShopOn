package com.example.digitron

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.digitron.databinding.SlidingViewBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageAdapter(
    private val context: Context,
    private val images: Array<Int>): SliderViewAdapter<ImageAdapter.ImageViewHolder>() {

    private lateinit var binding: SlidingViewBinding

    inner class ImageViewHolder(binding : SlidingViewBinding) : SliderViewAdapter.ViewHolder(binding.root)

    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ImageViewHolder {
        binding = SlidingViewBinding.inflate(LayoutInflater.from(context),parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ImageViewHolder?, position: Int) {
        binding.imageSlider.setImageResource(images[position])
    }


}