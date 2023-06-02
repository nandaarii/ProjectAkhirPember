package com.example.uijualbeliemas

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CatalogDao {
    @Query("SELECT * from Catalog")
    fun getAllCatalogs(): LiveData<List<Catalog>>

    @Insert
    fun insert(catalog: Catalog)

    @Update
    fun update(catalog: Catalog)

    @Query("DELETE FROM Catalog WHERE id = :CatalogId")
    fun deleteById(CatalogId: Int)
}