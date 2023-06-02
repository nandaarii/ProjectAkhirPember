package com.example.uijualbeliemas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Catalog::class], version = 1)
abstract class CatalogRoomDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao

    companion object {
        @Volatile
        private var INSTANCE: CatalogRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): CatalogRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatalogRoomDatabase::class.java, "catalog_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


