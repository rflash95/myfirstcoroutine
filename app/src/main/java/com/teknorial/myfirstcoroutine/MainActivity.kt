package com.teknorial.myfirstcoroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //delay = suspend function
        //doNetworkCall() suspend functiom hanya dapat dipanggil di dalam coroutine atau suspend function lainnya


        //GlobalScope :  Coroutine akan tetap hidup selama aplikasi kita berjalan, jika tidak selesai sebelumnya
        GlobalScope.launch {
            //delay : hanya membuat coroutine tertidur, tidak keseluruhan thread
            delay(3000L)
            Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")


            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()

            Log.d(TAG, networkCallAnswer)
            Log.d(TAG, networkCallAnswer2)
        }

        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")

    }

    //membuat suspend function
    suspend fun doNetworkCall(): String {
        delay(4000L)
        return "This is the answer"
    }

    //membuat suspend function
    suspend fun doNetworkCall2(): String {
        delay(4000L)
        return "this is the answer"
    }
}