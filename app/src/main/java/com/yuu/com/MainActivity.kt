package com.yuu.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var gameRV: RecyclerView
    private val list = ArrayList<comics>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameRV = findViewById(R.id.rv_game)
        gameRV.setHasFixedSize(true)

        list.addAll(getGameList())

        gameRV.layoutManager = LinearLayoutManager(this)

        val gamelist = adapter(list, this)
        gameRV.adapter = gamelist
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, about::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getGameList(): ArrayList<comics> {
        val dataComics = resources.getStringArray(R.array.comics_data)
        val dataDetail = resources.getStringArray(R.array.comics_desc)
        val dataOverview = resources.getStringArray(R.array.comics_overview_data)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_data)
        val gamelist = ArrayList<comics>()
        for (i in dataComics.indices) {
            val game = comics(dataComics[i], dataOverview[i], dataPhoto.getResourceId(i, -1), dataDetail[i],)
            gamelist.add(game)
        }
        dataPhoto.recycle()
        return gamelist
    }
}