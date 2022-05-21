package org.sopt.symphony.data.response

data class SampleResponse(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(val id: Int)
}
