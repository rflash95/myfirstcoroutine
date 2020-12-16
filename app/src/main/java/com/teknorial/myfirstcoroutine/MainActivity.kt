package com.teknorial.myfirstcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //GlobalScope :  Coroutine akan tetap hidup selama aplikasi kita berjalan, jika tidak selesai sebelumnya
        GlobalScope.launch {
            //delay : hanya membuat coroutine tertidur, tidak keseluruhan thread
            delay(3000)
            Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")
        }

        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")

    }
}