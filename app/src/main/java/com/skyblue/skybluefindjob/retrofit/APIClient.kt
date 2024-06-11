package com.skyblue.skybluefindjob.retrofit

import com.skyblue.skybluefindjob.model.Jobs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIClient {

    @GET("/get_jobs.php")
    fun getJobsList(): Call<List<Jobs>>

    companion object {

        var retrofitService: APIClient? = null

        fun getInstance() : APIClient {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jobs.skyblue.co.in")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(APIClient::class.java)
            }
            return retrofitService!!
        }
    }
}

//class APIClient {
//    val api: APIInterface by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://skyblue.co.in")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(APIInterface::class.java)
//    }
//}