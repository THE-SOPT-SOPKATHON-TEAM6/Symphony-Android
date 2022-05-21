package org.sopt.symphony.ui.symphony

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.data.SymphonyNoteData
import org.sopt.symphony.databinding.ActivitySymphonyBinding
import org.sopt.symphony.ui.postnote.PostNoteActivity
import org.sopt.symphony.ui.symphony.adapter.SymphonyAdapter

class SymphonyActivity : BaseActivity<ActivitySymphonyBinding>(R.layout.activity_symphony) {
    private lateinit var symphonyAdapter: SymphonyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRvAdapter()
        setRvItem()
        initDrawNoteBtnClick()
    }

    private fun setRvItem() {
        symphonyAdapter.submitList(dummy_list)
    }

    private fun initRvAdapter() {
        binding.rvSymphony.adapter =
            SymphonyAdapter(::onNoteClick).also { symphonyAdapter = it }
    }

    private fun onNoteClick(symphonyNoteData: SymphonyNoteData) {
        // dialog 띄우는 로직 들어감
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
    }

    private fun initDrawNoteBtnClick() {
        binding.btnDraw.setOnClickListener {
            val intent = Intent(this, PostNoteActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        val dummy_list = listOf(
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
            SymphonyNoteData(
                "hi",
                "https://user-images.githubusercontent.com/59546818/169656548-e95e16d8-88cb-4d31-a726-de7a1df711cf.png",
                "do",
                "2022-12-12"
            ),
        )
    }
}
