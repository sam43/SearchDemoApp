package com.example.looser43.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        startActivity(Intent(this, SearchActivity::class.java))
        Toast.makeText(this@MainActivity, "Working fine", Toast.LENGTH_SHORT).show()
    }

    private lateinit var toolbar: Toolbar
    private lateinit var search: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    private fun initializeViews() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        //toolbar.title = "Home"

        search = findViewById(R.id.search_edit)
        search.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.profile -> {
                goToProfile()
                true
            }
            /*R.id.help -> {
                showHelp()
                true
            }*/
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToProfile() {
        Toast.makeText(this@MainActivity, "Working on it", Toast.LENGTH_SHORT).show()
    }
}
