package org.sopt.symphony.data.response

import com.google.gson.annotations.SerializedName

data class PostNoteResponse(
    val status:Int,
    val message:String,
    val success:String,
    val data:Data
){
    data class Data(@SerializedName("countNum") val id: Int)
}
