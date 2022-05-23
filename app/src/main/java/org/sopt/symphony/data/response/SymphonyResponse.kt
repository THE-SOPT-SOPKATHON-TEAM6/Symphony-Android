package org.sopt.symphony.data.response

import org.sopt.symphony.data.model.SymphonyNoteData

data class SymphonyResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<SymphonyNoteData>
)
