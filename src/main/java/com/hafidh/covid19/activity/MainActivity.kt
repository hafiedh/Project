package com.hafidh.covid19.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hafidh.covid19.R
import com.hafidh.covid19.api.RetrofitClient
import com.hafidh.covid19.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()
        btnProvince.setOnClickListener {
           Intent(this, ProvinceActivity::class.java).also {
               startActivity(it)
           }
        }

    }
    fun showIndonesia() {
        RetrofitClient.Instance.getIndonesia()
            .enqueue(object : Callback<ArrayList<IndonesiaResponse>>{
                override fun onResponse(call: Call<ArrayList<IndonesiaResponse>>, response: Response<ArrayList<IndonesiaResponse>>
                ) {
                    val Indonesia : IndonesiaResponse? = response.body()?.get(0)
                    val positive : String? = Indonesia?.positif
                    val Recover : String? = Indonesia?.sembuh
                    val Death : String? = Indonesia?.meninggal
                    val Hospitalized : String? = Indonesia?.dirawat
                    tvPositive.text = positive
                    tvRecover.text = Recover
                    tvHospitalized.text = Hospitalized
                    tvDeath.text = Death

                }

                override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"${t.message}",Toast.LENGTH_LONG).show()
                }
                })

    }
}

