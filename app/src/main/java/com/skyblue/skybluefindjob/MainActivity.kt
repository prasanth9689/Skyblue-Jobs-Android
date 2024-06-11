package com.skyblue.skybluefindjob

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skyblue.skybluefindjob.adapter.MainAdapter
import com.skyblue.skybluefindjob.databinding.ActivityMainBinding
import com.skyblue.skybluefindjob.model.Jobs
import com.skyblue.skybluefindjob.repository.MainRepository
import com.skyblue.skybluefindjob.retrofit.APIClient
import com.skyblue.skybluefindjob.retrofit.APIInterface
import com.skyblue.skybluefindjob.viewmodelactory.MyViewModelFactory
import com.skyblue.skybluefindjob.viewmodels.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var context: Context = this@MainActivity
    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var viewModel: MainViewModel
    val adapter = MainAdapter()
    private val retrofitService = APIClient.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


       viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
     //   viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

      //  binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager


        viewModel.jobsList.observe(this, Observer {
            Log.e("res__", ""+ it)
            adapter.setJobsList(it)
        })

        viewModel.erroMessage.observe(this, Observer {
            Toast.makeText(context, "error!", Toast.LENGTH_SHORT).show()
        })
        viewModel.getJobsList()









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