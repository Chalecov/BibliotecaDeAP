package com.example.bibliotecaap.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aperturas_table")
data class Apertura(
    @PrimaryKey
    var nombre: String = "",
    var eco: String = "",
    var movimientos: String = "",
    var descripcion: String = ""
) {
    // Constructor required for Firebase/Firestore
    constructor() : this("", "", "", "")
}