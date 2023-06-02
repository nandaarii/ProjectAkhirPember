package com.example.uijualbeliemas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton: Button = findViewById(R.id.btnLogin)
        val etNama: EditText = findViewById(R.id.etEmail)
        val etPass: EditText = findViewById(R.id.etPassword)

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", "User@gmail.com")
        editor.putString("password", "password123")
        editor.apply()

        clickButton.setOnClickListener{
            val nama = etNama.text.toString()
            val pass = etPass.text.toString()
            val savedUsername = sharedPreferences.getString("username", "User@gmail.com")
            val savedPassword = sharedPreferences.getString("password", "password123")

            if(nama == savedUsername && pass == savedPassword) {
                val intent = Intent(this, HalamanDua::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan username & password dengan benar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}