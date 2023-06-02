package com.example.uijualbeliemas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uijualbeliemas.databinding.ActivityHalamanDuaBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HalamanDua : AppCompatActivity(), MainAdapter.OnItemClickListener {

    private lateinit var binding: ActivityHalamanDuaBinding
    private lateinit var myAdapter: MainAdapter
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHalamanDuaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<Catalog>()

        list.addAll(
            arrayOf(
                Catalog(1, R.drawable.emas1, "Kalung Emas India", "2 Terjual", "Rp.3.800.000"),
                Catalog(2, R.drawable.emas2, "Liontin", "5 Terjual", "Rp.1.580.000"),
                Catalog(3, R.drawable.emas3, "Gelang 18 Karat", "1 Terjual", "Rp.2.846.000"),
                Catalog(4, R.drawable.emas4, "Cincin Nikah 19 Karat", "7 Terjual", "Rp.3.123.000"),
                Catalog(5, R.drawable.emas5, "Gelang Emas", "9 Terjual", "Rp.2.244.000"),
                Catalog(6, R.drawable.emas6, "Kalung Import", "4 Terjual", "Rp.3.784.000"),
                Catalog(7, R.drawable.emas7, "Emas 22K Gelang", "11 Terjual", "Rp.8.240.000"),
                Catalog(8, R.drawable.emas8, "Cincin Pasangan", "16 Terjual", "Rp.4.400.000")
            )
        )

        myAdapter = MainAdapter(list, this)

        binding.recyView.layoutManager = GridLayoutManager(this, 2)
        binding.recyView.setHasFixedSize(true)
        binding.recyView.adapter = myAdapter

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, HalamanDua::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_cart-> {
                    // Tindakan yang ingin dilakukan saat menu Search dipilih
                    // Misalnya, tampilkan fragment atau lakukan navigasi ke halaman lain
                    val intent = Intent(this, KeranjangActivity::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_acc -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.halaman_dua, ProfileFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }


    override fun onItemClick(position: Int) {
        val selectedItem = myAdapter.list[position]
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("judul", selectedItem.judul)
        intent.putExtra("terjual", selectedItem.terjual)
        intent.putExtra("harga", selectedItem.harga)
        intent.putExtra("img", selectedItem.img)
        startActivity(intent)
    }
}