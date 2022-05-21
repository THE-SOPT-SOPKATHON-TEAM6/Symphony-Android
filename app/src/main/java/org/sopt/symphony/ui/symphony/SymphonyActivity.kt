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
    private lateinit var dummyList: MutableList<SymphonyNoteData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUserName()
        initRvAdapter()
        initDrawNoteBtnClick()
    }

    override fun onStart() {
        super.onStart()
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
                    dummyList = data?.toMutableList() ?: throw IllegalStateException()
                    Log.d(TAG, "onResponse: $dummyList")
                    val tmp = refactorList(dummyList)
                    symphonyAdapter.submitList(tmp)
                } else Log.d(TAG, "onResponse_not_success: ${response.errorBody()?.string()}")
            }

            override fun onFailure(call: Call<SymphonyResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }
        })
    }

    private fun refactorList(originList: MutableList<SymphonyNoteData>): MutableList<SymphonyNoteData> {
        var idx = 0
        val markNote = SymphonyNoteData("-1", MARK_NOTE, "-1", "-1")
        val emptyNote = SymphonyNoteData("-1", EMPTY_NOTE, "-1", "-1")
        val refactorList: MutableList<SymphonyNoteData> = arrayListOf()

        for (i in 0..23) {
            if (i == 0 || i == 8 || i == 16) {
                refactorList.add(i, markNote)
                continue
            } else {
                if (idx < originList.size) {
                    Log.d(TAG, "refactorList: ${originList[idx]} ")
                    refactorList.add(i, originList[idx])
                    idx += 1
                    continue
                } else refactorList.add(i, emptyNote)
            }
        }
        return refactorList
    }

    private fun initRvAdapter() {
        binding.rvSymphony.adapter =
            SymphonyAdapter(::onNoteClick).also { symphonyAdapter = it }
    }

    private fun onNoteClick(symphonyNoteData: SymphonyNoteData) {
        if (symphonyNoteData.content != "-1") {
            val dialog = DialogNoteDetail(symphonyNoteData)
            dialog.show(supportFragmentManager, this.javaClass.name)
        }
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
        const val MARK_NOTE =
            "https://user-images.githubusercontent.com/59546818/169668121-d2a84652-7a8c-4adf-8c82-b7b983b120f6.png"
        const val EMPTY_NOTE =
            "https://user-images.githubusercontent.com/59546818/169668122-1adaba21-4be7-477f-8967-3c13a3e17004.png"
    }
}
