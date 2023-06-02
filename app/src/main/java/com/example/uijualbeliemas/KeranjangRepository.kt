package com.example.uijualbeliemas

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class KeranjangRepository(application: Application) {
    private val catalogDao: CatalogDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = CatalogRoomDatabase.getDatabase(application)
        catalogDao = db.catalogDao()
    }

    fun insert(catalog: Catalog) {
        executorService.execute { catalogDao.insert(catalog) }
    }

    fun update(catalog: Catalog) {
        executorService.execute { catalogDao.update(catalog) }
    }

    fun deleteCatalogById(id: Int) {
        executorService.execute { catalogDao.deleteById(id) }
    }

    fun getAllCatalogs(): LiveData<List<Catalog>>{
        return catalogDao.getAllCatalogs()
    }

    fun tambahKeKeranjang(catalog: Catalog) {
        insert(catalog)
    }

}
