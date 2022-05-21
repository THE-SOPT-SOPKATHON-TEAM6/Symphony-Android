package org.sopt.symphony.ui.postnote

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.data.RetrofitBuilder
import org.sopt.symphony.data.request.PostNoteRequest
import org.sopt.symphony.data.response.PostNoteResponse
import org.sopt.symphony.databinding.ActivityPostNoteBinding
import org.sopt.symphony.util.DialogScoreComplete
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostNoteActivity : BaseActivity<ActivityPostNoteBinding>(R.layout.activity_post_note) {

    var checkedNote = ""

    companion object {
        const val CHECK_NOTE_DOE = "note1"
        const val CHECK_NOTE_MI = "note2"
        const val CHECK_NOTE_SOL = "note3"
        const val CHECK_NOTE_SI = "note4"
        const val CHECK_NOTE_RAE = "note5"
        const val LAST_NOTE = 21
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentDate()
        getCheckedNote()
        initBtnEvent()
    }

    // 현재 날짜 가져오기
    private fun setCurrentDate() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern(getString(R.string.date_formant_kr))
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
                        checkedNote = CHECK_NOTE_DOE
                    }
                    R.id.radio_mi -> {
                        checkedNote = CHECK_NOTE_MI
                    }
                    R.id.radio_sol -> {
                        checkedNote = CHECK_NOTE_SOL
                    }
                    R.id.radio_si -> {
                        checkedNote = CHECK_NOTE_SI
                    }
                    R.id.radio_rae -> {
                        checkedNote = CHECK_NOTE_RAE
                    }
                    else -> {
                        checkedNote = CHECK_NOTE_DOE
                    }
                }
            }
        })
    }

    // 버튼 이벤트 등록
    private fun initBtnEvent() {
        binding.btnDone.setOnClickListener {
            // 서버 통신 시도
            tryPostNote()
        }
    }

    private fun showDialog() {
        val dialog = DialogScoreComplete(::doAfterConfirm)
        dialog.show(supportFragmentManager, this.javaClass.name)
    }

    private fun doAfterConfirm() {
        finish()
    }

    private fun tryPostNote() {
        val postNoteRequest = PostNoteRequest(
            checkedNote,
            binding.etvContent.text.toString(),
            binding.tvDate.text.toString()
        )
        val call: Call<PostNoteResponse> = RetrofitBuilder.getInstance().postBoard(postNoteRequest)

        call.enqueue(object : Callback<PostNoteResponse> {
            override fun onResponse(
                call: Call<PostNoteResponse>,
                response: Response<PostNoteResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    //Log.d(TAG, "onResponse_success: $data")

                    // 21번째 글이면 다이얼로그 보여주기
                    if (data?.id == LAST_NOTE) showDialog()
                    else finish()

                } else {
                    //Log.d(TAG, "onResponse_not_success: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<PostNoteResponse>, t: Throwable) {
                //Log.d(TAG, "onFailure: $t")
            }
        })
    }

}
