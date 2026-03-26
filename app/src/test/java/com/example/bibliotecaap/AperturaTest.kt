package com.example.bibliotecaap

import com.example.bibliotecaap.data.Apertura
import org.junit.Test
import org.junit.Assert.*

class AperturaTest {
    @Test
    fun `validar que la apertura se crea correctamente`() {
        val apertura = Apertura(nombre = "Gambito de Dama", eco = "D06")
        assertEquals("Gambito de Dama", apertura.nombre)
        assertEquals("D06", apertura.eco)
    }
}