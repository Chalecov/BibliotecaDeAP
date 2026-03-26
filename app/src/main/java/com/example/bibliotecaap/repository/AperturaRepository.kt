package com.example.bibliotecaap.repository

import androidx.lifecycle.LiveData
import com.example.bibliotecaap.data.Apertura
import com.example.bibliotecaap.db.AperturaDao
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AperturaRepository(private val aperturaDao: AperturaDao) {

    // Obtenemos las aperturas guardadas en el celular (SQLite/Room)
    val allAperturas: LiveData<List<Apertura>> = aperturaDao.getAllAperturas()

    fun refreshAperturas() {
        val db = FirebaseFirestore.getInstance()
        db.collection("aperturas").addSnapshotListener { result, _ ->
            val lista = result?.toObjects(Apertura::class.java) ?: emptyList()

            // Usamos Coroutines para guardar en la base de datos local sin trabar la app
            CoroutineScope(Dispatchers.IO).launch {
                aperturaDao.insertAperturas(lista)
            }
        }
    }
}