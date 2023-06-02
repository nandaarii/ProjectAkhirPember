package com.example.uijualbeliemas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Catalog(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "foto")
    val img: Int,

    @ColumnInfo(name = "nama")
    val judul: String,

    @ColumnInfo(name = "info")
    val terjual: String,

    @ColumnInfo(name = "harga")
    val harga: String,

    @ColumnInfo(name = "isDone")
    var isDone: Boolean = false
)
