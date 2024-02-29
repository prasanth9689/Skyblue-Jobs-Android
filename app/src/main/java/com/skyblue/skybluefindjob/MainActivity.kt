package com.skyblue.skybluefindjob

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.skyblue.skybluefindjob.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var context: Context = this@MainActivity
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.firstItem -> {
                        Toast.makeText(context, "First Item Clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.secondtItem -> {
                        Toast.makeText(context, "Second Item Clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.thirdItem -> {
                        Toast.makeText(context, "third Item Clicked", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }

        binding.menu.setOnClickListener{
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}