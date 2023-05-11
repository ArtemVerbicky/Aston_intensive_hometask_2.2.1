
package ru.verb.aston_intensive_hometask_2_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.verb.aston_intensive_hometask_2_2_1.MainActivity.Companion.EXTRA_MESSAGE
import ru.verb.aston_intensive_hometask_2_2_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val EXTRA_REPLY = "EXTRA_REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }
        intent.getStringExtra(EXTRA_MESSAGE).apply {
            this?.let {
                binding.textMessage.text = it
            }
        }

        with(binding) {
            buttonSecond.setOnClickListener {
                returnReply()
                editTextSecond.setText("")
            }
        }

    }

    private fun returnReply() {
        Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_REPLY, binding.editTextSecond.text.toString())
            setResult(RESULT_OK, this)
            finish()
        }
    }
}