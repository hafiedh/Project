package com.hafidh.covid19.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar

import androidx.recyclerview.widget.LinearLayoutManager
import com.hafidh.covid19.R
import com.hafidh.covid19.adapter.ProvinceAdapter
import com.hafidh.covid19.api.RetrofitClient
import com.hafidh.covid19.model.ProvinceResponse
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        supportActionBar?.setTitle("Kasus Provinsi")
        showProvince();
    }
    private fun showProvince(){
        rvProvince.layoutManager = LinearLayoutManager(this)
        rvProvince.setHasFixedSize(true)
        RetrofitClient.Instance.getProvince().enqueue(object : Callback<ArrayList<ProvinceResponse>>{
            override fun onResponse(call: Call<ArrayList<ProvinceResponse>>, response: Response<ArrayList<ProvinceResponse>>) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                rvProvince.adapter= adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }

        })


    }
}