package com.skyblue.skybluefindjob

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skyblue.skybluefindjob.adapter.MainAdapter
import com.skyblue.skybluefindjob.databinding.ActivityMainBinding
import com.skyblue.skybluefindjob.repository.MainRepository
import com.skyblue.skybluefindjob.retrofit.APIClient
import com.skyblue.skybluefindjob.viewmodelactory.MyViewModelFactory
import com.skyblue.skybluefindjob.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var context: Context = this@MainActivity
    lateinit var viewModel: MainViewModel
    val adapter = MainAdapter()
    private val retrofitService = APIClient.getInstance()
    lateinit var  actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

       viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager


        viewModel.jobsList.observe(this, Observer {
            Log.e("res__", ""+ it)
            adapter.setJobsList(it)
            binding.shimmerLayout.visibility  = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        })

        viewModel.erroMessage.observe(this, Observer {
            Toast.makeText(context, "error!", Toast.LENGTH_SHORT).show()
        })
        viewModel.getJobsList()

        onClickListener()


    }



    private fun openDrawer(drawerLayout: DrawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    fun closeDrawer(drawerLayout: DrawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    private fun onClickListener() {
        binding.menu.setOnClickListener(){
            openDrawer(binding.drawerLayout)
        }
    }

    override fun onPause() {
        super.onPause()
        closeDrawer(binding.drawerLayout)
    }
}