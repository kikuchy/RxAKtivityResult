package net.kikuchy.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.jakewharton.rxbinding.view.clicks
import net.kikuchy.rxaktivityresult.RxAKtivityResult
import net.kikuchy.rxaktivityresult.RxAKtivityResultDelegate
import net.kikuchy.rxaktivityresult.isOk
import net.kikuchy.rxaktivityresult.isRequestOf

class MainActivity : AppCompatActivity(), RxAKtivityResult by RxAKtivityResultDelegate() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text) as TextView
        textView.
                clicks().
                subscribe {
                    startActivityForResult(Intent(this, NextActivity::class.java), REQUEST)
                }

        activityResultObservable.
                isOk().
                isRequestOf(REQUEST).
                subscribe {
                    val (requestCode, resultCode, data) = it
                    textView.text = data?.getStringExtra(NextActivity.ARG1)
                }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super<AppCompatActivity>.onActivityResult(requestCode, resultCode, data)
        super<RxAKtivityResult>.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        const val REQUEST = 1234
    }
}
