package com.skyblue.skybluefindjob.retrofit

import com.skyblue.skybluefindjob.model.Jobs
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/skyblue/get_common_data.php")
    fun getJobsList(): Call<List<Jobs>>
}