package com.example.niraviman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.niraviman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottomBar.setupWithNavController(navController)
        binding.drawerNav.setupWithNavController(navController)

        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.nav_open, R.string.nav_close)
        actionBarDrawerToggle.syncState()

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }
        else {
            super.onOptionsItemSelected(item)
        }
    }

}