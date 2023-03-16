package com.fizahra.mybgthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val tvStatus = findViewById<TextView>(R.id.tv_status)

//        val executer = Executors.newSingleThreadExecutor()
//        val handler = Handler(Looper.getMainLooper())

        btnStart.setOnClickListener {
//            executer.execute {
            lifecycleScope.launch(Dispatchers.Default) {
//                try {
                for (i in 0..10) {
//                    Thread.sleep(500)
                    delay(500)
                    val percen = i * 10
//                        handler.post {
                    withContext(Dispatchers.Main) {
                        if (percen == 100) {
                            tvStatus.setText(R.string.task_completed)
                        } else {
                            tvStatus.text =
                                String.format(getString(R.string.compressing), percen)
                        }
                    }
//                        }
                }
            }

                }
//        catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
        }
//    }
}