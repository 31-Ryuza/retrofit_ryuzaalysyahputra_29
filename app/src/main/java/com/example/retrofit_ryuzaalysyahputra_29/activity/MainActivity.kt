package com.example.retrofit_ryuzaalysyahputra_29.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.retrofit_ryuzaalysyahputra_29.R
import com.example.retrofit_ryuzaalysyahputra_29.api.RetrofitClient
import com.example.retrofit_ryuzaalysyahputra_29.api.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showIndonesia()

        val btnProvince : Button = findViewById(R.id.btnProvince)
        btnProvince.setOnClickListener {
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>> {

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                cal: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitalized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                val tvPositive : TextView = findViewById(R.id.tvPositive)
                val tvHospitalized : TextView = findViewById(R.id.tvHospitalized)
                val tvRecover : TextView = findViewById(R.id.tvRecover)
                val tvDeath : TextView = findViewById(R.id.tvDeath)

                tvPositive.text = positive
                tvHospitalized.text = hospitalized
                tvRecover.text = recover
                tvDeath.text = death
            }
        })
    }
}