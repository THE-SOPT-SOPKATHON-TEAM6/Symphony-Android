package org.sopt.symphony.ui.postnote

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.data.RetrofitBuilder
import org.sopt.symphony.data.request.PostNoteRequest
import org.sopt.symphony.data.response.PostNoteResponse
import org.sopt.symphony.databinding.ActivityPostNoteBinding
import retrofit2.Call
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostNoteActivity : BaseActivity<ActivityPostNoteBinding>(R.layout.activity_post_note) {

    var checkedNote = "" // 선택된 음표

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentDate()
        getCheckedNote()
        initBtnEvent()
    }

    // 현재 날짜 가져오기
    private fun setCurrentDate() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
        val formatted = current.format(formatter)

        binding.tvDate.text = formatted
    }

    // 체크된 음표 가져오기
    private fun getCheckedNote() {
        binding.radioGroupNote.setOnCheckedChangeListener(object :
            RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(radioGroup: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.radio_do -> {
                        checkedNote = "도"
                    }
                    R.id.radio_mi -> {
                        checkedNote = "미"
                    }
                    R.id.radio_sol -> {
                        checkedNote = "솔"
                    }
                    R.id.radio_si -> {
                        checkedNote = "시"
                    }
                    R.id.radio_rae -> {
                        checkedNote = "레"
                    }
                    else -> {
                        checkedNote = "도"
                    }
                }
            }

        })
    }

    private fun initBtnEvent(){
        binding.btnDone.setOnClickListener {
            // 서버 통신 시도
            // tryPostNote()
            finish()
        }
    }

    private fun tryPostNote() {
        val postNoteRequest= PostNoteRequest(checkedNote,binding.etvContent.text.toString(),binding.tvDate.text.toString())
        // val call: Call<PostNoteResponse> = RetrofitBuilder.getInstance().posttarget(postNoteRequest)

        /*call.enqueue(object : Callback<PostNoteResponse> {
            override fun onResponse(
                call: Call<targetResponse>,
                response: Response<targetResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Log.d(TAG, "onResponse_success: $data")
                } else{
                    Log.d(TAG, "onResponse_not_success: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<targetResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }
        })*/
    }
}
