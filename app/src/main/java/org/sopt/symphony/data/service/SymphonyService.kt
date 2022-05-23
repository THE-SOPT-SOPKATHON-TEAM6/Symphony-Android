package org.sopt.symphony.data.service

import org.sopt.symphony.data.request.PostNoteRequest
import org.sopt.symphony.data.response.PostNoteResponse
import org.sopt.symphony.data.response.SymphonyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SymphonyService {
    //    @POST("auth/signup")
    //    fun postSignUp(
    //        @Body body: SignUpRequest
    //    ): Call<SignUpResponse>

    // 글쓰기 post
    @POST("board")
    fun postBoard(
        @Body body: PostNoteRequest
    ): Call<PostNoteResponse>

    @GET("boards")
    fun getNote(): Call<SymphonyResponse>
}
