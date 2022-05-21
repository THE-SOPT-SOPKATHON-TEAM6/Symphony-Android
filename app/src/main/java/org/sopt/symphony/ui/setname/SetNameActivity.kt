package org.sopt.symphony.ui.setname

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.symphony.R
import org.sopt.symphony.databinding.ActivitySetNameBinding
import org.sopt.symphony.ui.symphony.SymphonyActivity

class SetNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNameFinish.setOnClickListener {
            if (binding.etName.text.isNullOrBlank()) {
                Toast.makeText(this, "이름이 입력되지 않았습니다", Toast.LENGTH_SHORT).show()
                binding.btnNameFinish.setBackgroundColor(binding.btnNameFinish.context.getColor(R.color.btn_inactive))
            } else {
                binding.btnNameFinish.setBackgroundColor(binding.btnNameFinish.context.getColor(R.color.purple))
                val intent = Intent(this@SetNameActivity, SymphonyActivity::class.java)
                intent.putExtra("name", binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}