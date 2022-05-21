package org.sopt.symphony.ui.symphony

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.data.RetrofitBuilder
import org.sopt.symphony.data.model.SymphonyNoteData
import org.sopt.symphony.data.response.SymphonyResponse
import org.sopt.symphony.databinding.ActivitySymphonyBinding
import org.sopt.symphony.ui.postnote.PostNoteActivity
import org.sopt.symphony.ui.symphony.adapter.SymphonyAdapter
import org.sopt.symphony.util.DialogNoteDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SymphonyActivity : BaseActivity<ActivitySymphonyBinding>(R.layout.activity_symphony) {
    private lateinit var symphonyAdapter: SymphonyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUserName()
        initRvAdapter()
        setRvItem()
        initDrawNoteBtnClick()
        getSymphonyData()
    }

    private fun getSymphonyData() {
        val call = RetrofitBuilder.getInstance().getNote()
        call.enqueue(object : Callback<SymphonyResponse> {
            override fun onResponse(
                call: Call<SymphonyResponse>,
                response: Response<SymphonyResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Log.d(TAG, "onResponse_success: $data")
                } else {
                    Log.d(TAG, "onResponse_not_success: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<SymphonyResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }
        })
    }

    private fun setRvItem() {
        symphonyAdapter.submitList(dummy_list)
    }

    private fun initRvAdapter() {
        binding.rvSymphony.adapter =
            SymphonyAdapter(::onNoteClick).also { symphonyAdapter = it }
    }

    private fun onNoteClick(symphonyNoteData: SymphonyNoteData) {
        val dialog = DialogNoteDetail(symphonyNoteData)
        dialog.show(supportFragmentManager, this.javaClass.name)
    }

    private fun initDrawNoteBtnClick() {
        binding.btnDraw.setOnClickListener {
            val intent = Intent(this, PostNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUserName() {
        binding.tvName.text = intent.getStringExtra("name")
    }

    companion object {
        val dummy_list = listOf(
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "오늘 솝커톤을 했다. 좋은 팀원들을 만나 재밌게 열심히 프로젝트 한다. 일상을 주제로 해서 앱을 만들고 있다. 우리는 대상을 탈거고 인기상 운명이기도 하다",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
        )
    }
}
