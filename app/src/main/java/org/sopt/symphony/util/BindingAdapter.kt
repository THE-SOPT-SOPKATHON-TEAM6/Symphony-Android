package org.sopt.symphony.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUrl")
fun ImageView.setImage(url: String) {
    Glide.with(this).load(url).into(this)
}
