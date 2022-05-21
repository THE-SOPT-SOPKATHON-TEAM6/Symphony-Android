package org.sopt.symphony.ui.setname

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
                Toast.makeText(this,"이름이 입력되지 않았습니다", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SetNameActivity, SymphonyActivity::class.java)
                intent.putExtra("name", binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
