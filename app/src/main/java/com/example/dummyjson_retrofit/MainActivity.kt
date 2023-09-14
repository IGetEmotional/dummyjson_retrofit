package com.example.dummyjson_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var sign_name: TextView
    lateinit var retrofit: Retrofit
    lateinit var productApi: ProductApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById<TextView>(R.id.tv)
        sign_name = findViewById<TextView>(R.id.sign_name)

         retrofit = Retrofit.Builder()
            .baseUrl("https://horoscopes-ai.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
         productApi = retrofit.create(ProductApi::class.java)

    }

    fun onClick(v: View){
        when(v.id){
            R.id.aries_btn,
            R.id.taurus_btn,
            R.id.gemini_btn,
            R.id.cancer_btn,
            R.id.leo_btn,
            R.id.virgo_btn,
            R.id.libra_btn,
            R.id.scorpio_btn,
            R.id.sagittarius_btn,
            R.id.capricorn_btn,
            R.id.aquarius_btn,
            R.id.pisces_btn->{
                //  val retrofit = Retrofit.Builder()
                //       .baseUrl("https://horoscopes-ai.p.rapidapi.com")
                //       .addConverterFactory(GsonConverterFactory.create()).build()
                val productApi = retrofit.create(ProductApi::class.java)

                CoroutineScope(Dispatchers.IO).launch {
                    val product = productApi.getProduct(resources.getString(R.string.API_KEY), v.tooltipText.toString())
                    runOnUiThread {
                         tv.text = product.general[0]
                        sign_name.text = product.sign
                    }
                }
            }

        }
    }
}