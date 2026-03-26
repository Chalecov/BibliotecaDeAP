package com.example.bibliotecaap.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliotecaap.R

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        //lista
        val nombre = intent.getStringExtra("nombre")
        val movimientos = intent.getStringExtra("movimientos")
        val descripcion = intent.getStringExtra("descripcion")
        val eco = intent.getStringExtra("eco")

        //TextView
        findViewById<TextView>(R.id.tvDetalleNombre).text = nombre
        findViewById<TextView>(R.id.tvDetalleEco).text = "ECO: $eco"
        findViewById<TextView>(R.id.tvDetalleMovimientos).text = movimientos
        findViewById<TextView>(R.id.tvDetalleDescripcion).text = descripcion

        //botón
        val btnReportar = findViewById<Button>(R.id.btnReportar)
        btnReportar.setOnClickListener {
            enviarSugerencia(nombre ?: "Apertura desconocida")
        }
    }

    private fun enviarSugerencia(nombreApertura: String) {
        //Correo
        val intentCorreo = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("fcolopezc5@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Sugerencia: $nombreApertura")
            putExtra(Intent.EXTRA_TEXT, "Hola, me gustaría sugerir lo siguiente para esta apertura...")
        }

        try {
            //Escoooger apps
            startActivity(Intent.createChooser(intentCorreo, "Enviar sugerencia usando:"))
        } catch (e: Exception) {
            // Errores
            Toast.makeText(this, "No tienes una aplicación de correo instalada", Toast.LENGTH_SHORT).show()
        }
    }
}