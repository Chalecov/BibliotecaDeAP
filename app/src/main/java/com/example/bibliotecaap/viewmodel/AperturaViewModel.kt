package com.example.bibliotecaap.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bibliotecaap.data.Apertura
import com.example.bibliotecaap.db.AppDatabase
import com.example.bibliotecaap.repository.AperturaRepository

class AperturaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AperturaRepository

    // Mainactivity observa esto
    val aperturas: LiveData<List<Apertura>>

    init {
        val dao = AppDatabase.getDatabase(application).aperturaDao()
        repository = AperturaRepository(dao)
        aperturas = repository.allAperturas
    }

    fun cargarAperturas() {
        repository.refreshAperturas()
    }
}