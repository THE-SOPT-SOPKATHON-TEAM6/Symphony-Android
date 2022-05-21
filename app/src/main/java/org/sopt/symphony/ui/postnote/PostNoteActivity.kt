package org.sopt.symphony.ui.postnote

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.databinding.ActivityPostNoteBinding
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

        }
    }


}
