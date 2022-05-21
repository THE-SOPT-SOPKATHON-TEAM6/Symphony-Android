package org.sopt.symphony.ui.symphony

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.symphony.databinding.ActivitySymphonyBinding

class SymphonyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySymphonyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySymphonyBinding.inflate(layoutInflater)
        setContentView(binding.root)

    // 이름 입력 버튼 누르고 intent로 넘기는 코드입니다!
//        binding.btnNameFinish.setOnClickListener() {
//            val intent = Intent(this, SetNameActivity::class.java)
//            intent.getStringExtra("name")
//        }
    }
}
