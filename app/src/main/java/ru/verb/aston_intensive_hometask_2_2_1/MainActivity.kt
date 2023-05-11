package ru.verb.aston_intensive_hometask_2_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import ru.verb.aston_intensive_hometask_2_2_1.SecondActivity.Companion.EXTRA_REPLY
import ru.verb.aston_intensive_hometask_2_2_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            binding.replyGroup.visibility = View.VISIBLE
            binding.textMessageReply.text = result.data?.getStringExtra(EXTRA_REPLY)
        }
    }

    companion object {
        val LOG_TAG: String = MainActivity::class.java.simpleName
        const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        with(binding) {
            buttonMain.setOnClickListener {
                launchSecondActivity()
                editTextMain.setText("")
            }
        }

    }
    private fun launchSecondActivity() {
        Log.d(LOG_TAG, "Button clicked!")
        Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, binding.editTextMain.text.toString())
            resultLauncher.launch(this)
        }
    }
}