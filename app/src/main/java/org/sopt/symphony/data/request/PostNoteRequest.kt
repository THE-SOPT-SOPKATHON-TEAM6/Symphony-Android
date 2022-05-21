package org.sopt.symphony.data.request

data class PostNoteRequest(
    val scoreType: String,
    val content: String,
    val createdAt: String
)
