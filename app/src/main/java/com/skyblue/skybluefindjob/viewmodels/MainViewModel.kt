package com.skyblue.skybluefindjob.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skyblue.skybluefindjob.model.Jobs
import com.skyblue.skybluefindjob.repository.MainRepository
import com.skyblue.skybluefindjob.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class MainViewModel (private val mainRepository: MainRepository) : ViewModel(){
    val jobsList = MutableLiveData<List<Jobs>>()
    val erroMessage = MutableLiveData<String>()

    fun getJobsList(){
        val response = mainRepository.getJobsList()

        response.enqueue(object : Callback<List<Jobs>> {
            override fun onResponse(call: Call<List<Jobs>>, response: Response<List<Jobs>>) {
                jobsList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Jobs>>, t: Throwable) {
                erroMessage.postValue(t.message)
            }

        })
    }
}