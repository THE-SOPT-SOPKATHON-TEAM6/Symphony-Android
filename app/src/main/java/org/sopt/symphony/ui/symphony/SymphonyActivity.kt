package org.sopt.symphony.ui.symphony

import android.content.Intent
import android.os.Bundle
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.databinding.ActivitySymphonyBinding
import org.sopt.symphony.ui.postnote.PostNoteActivity

class SymphonyActivity : BaseActivity<ActivitySymphonyBinding>(R.layout.activity_symphony) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDrawNoteBtnClick()
    }

    private fun initDrawNoteBtnClick() {
        binding.btnDraw.setOnClickListener {
            val intent = Intent(this, PostNoteActivity::class.java)
            startActivity(intent)
        }
    }
}
