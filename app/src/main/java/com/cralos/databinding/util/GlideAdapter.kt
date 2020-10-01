package com.cralos.databinding.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cralos.databinding.R

class GlideAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("imageDrawableResource")
        fun setImageResource(imageView: ImageView, image: Int) {
            val context = imageView.context
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(image)
                .into(imageView)
        }
    }

}