package com.yuu.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class slash : AppCompatActivity() {
    private val load = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_slash)
        Handler().postDelayed({
            val loginIntent = Intent(this@slash, MainActivity::class.java)
            startActivity(loginIntent)
            finish()
        }, load)

        supportActionBar?.hide()
    }
}