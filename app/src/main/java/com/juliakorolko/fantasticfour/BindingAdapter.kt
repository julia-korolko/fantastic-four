package com.juliakorolko.fantasticfour

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.juliakorolko.fantasticfour.comicOverview.MarvelApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image_24))
            .transition(withCrossFade())
            .fitCenter()
            .into(imgView)
    }
}

@BindingAdapter("marvelApiStatus")
fun bindStatus(statusImageView: ImageView, status: MarvelApiStatus?) {
    when (status) {
        MarvelApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MarvelApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
        }
        MarvelApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}