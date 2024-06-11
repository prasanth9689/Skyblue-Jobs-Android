package com.skyblue.skybluefindjob.repository

import com.skyblue.skybluefindjob.retrofit.APIClient
import com.skyblue.skybluefindjob.retrofit.APIInterface

class MainRepository constructor(private val apiInterface: APIClient){
    fun getJobsList() = apiInterface.getJobsList()
}