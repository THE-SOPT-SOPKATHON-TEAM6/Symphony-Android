package org.sopt.symphony.ui.symphony

import android.content.Intent
import android.os.Bundle
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.symphony.R
import org.sopt.symphony.data.model.SymphonyNoteData
import org.sopt.symphony.databinding.ActivitySymphonyBinding
import org.sopt.symphony.ui.postnote.PostNoteActivity
import org.sopt.symphony.ui.symphony.adapter.SymphonyAdapter
import org.sopt.symphony.util.DialogUtil

class SymphonyActivity : BaseActivity<ActivitySymphonyBinding>(R.layout.activity_symphony) {
    private lateinit var symphonyAdapter: SymphonyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setUserName()
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
        val dialog = DialogUtil(DialogUtil.SHOW_NOTE, symphonyNoteData)
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
