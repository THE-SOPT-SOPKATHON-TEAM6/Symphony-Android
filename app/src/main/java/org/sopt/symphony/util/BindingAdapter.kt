package org.sopt.symphony.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUri")
fun ImageView.setImage(@DrawableRes uri: Int) {
    Glide.with(this).load(uri).circleCrop().into(this)
}
