package com.example.uijualbeliemas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val judul = intent.getStringExtra("judul")
        val terjual = intent.getStringExtra("terjual")
        val harga = intent.getStringExtra("harga")
        val img = intent.getIntExtra("img", R.drawable.emas1)

        val tvJudul = findViewById<TextView>(R.id.mainJudul)
        tvJudul.text = judul

        val tvTerjual = findViewById<TextView>(R.id.mainTerjual)
        tvTerjual.text = terjual

        val tvHarga = findViewById<TextView>(R.id.mainHarga)
        tvHarga.text = harga

        val mainImg = findViewById<ImageView>(R.id.mainImage)
        mainImg.setImageResource(img)

        val btnPayment = findViewById<Button>(R.id.btnBeli)
        val dataJudul = findViewById<TextView>(R.id.mainJudul)
        val dataHarga = findViewById<TextView>(R.id.mainHarga)

        btnPayment.setOnClickListener {
            val intent = Intent(this, BeliActivity::class.java)
            val bundle = Bundle()

            bundle.putString("datajudul", dataJudul.text.toString())
            bundle.putString("dataharga", dataHarga.text.toString())

            intent.putExtras(bundle)
            startActivity(intent)
        }

        //intent
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, dataJudul.text.toString() + "\n" + dataHarga.text.toString())

        val chooserIntent = Intent.createChooser(shareIntent, "Bagikan menggunakan")

        if (shareIntent.resolveActivity(packageManager) != null) {
            startActivity(chooserIntent)
        }
    }
}