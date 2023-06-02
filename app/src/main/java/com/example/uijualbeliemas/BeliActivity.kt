package com.example.uijualbeliemas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class BeliActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beli)

        val bundle = intent.extras
        val judul = bundle?.getString("datajudul")
        val harga = bundle?.getString("dataharga")

        val tvJudul = findViewById<TextView>(R.id.textViewJudul)
        tvJudul.text = judul

        val tvHarga = findViewById<TextView>(R.id.textViewHarga)
        tvHarga.text = harga

        val clickBankBca: CardView = findViewById(R.id.cvBca)
        val clickBankBri: CardView = findViewById(R.id.cvBri)
        val clickBankMandiri: CardView = findViewById(R.id.cvMandiri)

        val changeTextBank: TextView = findViewById(R.id.textViewBank)

        clickBankBca.setOnClickListener{
            changeTextBank.text = "Bank BCA"
        }
        clickBankBri.setOnClickListener{
            changeTextBank.text = "Bank BRI"
        }
        clickBankMandiri.setOnClickListener{
            changeTextBank.text = "Bank Mandiri"
        }

        val myButton = findViewById<Button>(R.id.btnBayar)
        val myLayout = findViewById<LinearLayout>(R.id.showSukses)

        myButton.setOnClickListener {
            if (myLayout.visibility == View.INVISIBLE) {
                myLayout.visibility = View.VISIBLE
            }
        }

        val btnKembali = findViewById<Button>(R.id.btnBack)

        btnKembali.setOnClickListener {
            val intent = Intent(this, HalamanDua::class.java)
            startActivity(intent)
        }

        val dataJudul = findViewById<TextView>(R.id.textViewJudul)
        val dataHarga = findViewById<TextView>(R.id.textViewHarga)

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, dataJudul.text.toString() + "\n" + dataHarga.text.toString())

        val chooserIntent = Intent.createChooser(shareIntent, "Bagikan menggunakan")

        if (shareIntent.resolveActivity(packageManager) != null) {
            startActivity(chooserIntent)
        }
    }
}