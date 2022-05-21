package org.sopt.symphony.ui.postnote

import android.os.Bundle
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.databinding.ActivityPostNoteBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostNoteActivity : BaseActivity<ActivityPostNoteBinding>(R.layout.activity_post_note) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentDate()
    }

    // 현재 날짜 가져오기
    private fun setCurrentDate() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
        val formatted = current.format(formatter)

        binding.tvDate.text = formatted
    }
}
