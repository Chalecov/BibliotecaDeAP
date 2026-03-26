package com.example.bibliotecaap.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bibliotecaap.data.Apertura

@Dao
interface AperturaDao {
    @Query("SELECT * FROM aperturas_table")
    fun getAllAperturas(): LiveData<List<Apertura>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAperturas(aperturas: List<Apertura>)
}