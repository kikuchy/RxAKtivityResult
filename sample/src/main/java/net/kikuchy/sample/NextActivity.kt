package net.kikuchy.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val btn: Button = findViewById(R.id.returnbutton) as Button
        btn.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(ARG1, "hoge")
            })
            finish()
        }
    }

    companion object {
        const val ARG1 = "arg1"
    }
}
