package com.example.dummyjson_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @Headers(
        "X-RapidAPI-Host: horoscopes-ai.p.rapidapi.com"
    //    "X-RapidAPI-Key: \${R.string.API_KEY}"
    )
    @GET("get_horoscope/{sign}/today/general/en")
    suspend fun getProduct(@Header("X-RapidAPI-Key") x_rapidapi_key: String , @Path("sign") sign: String): Product

}