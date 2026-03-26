package com.example.bibliotecaap.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliotecaap.R
import com.example.bibliotecaap.viewmodel.AperturaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AperturaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvAperturas = findViewById<RecyclerView>(R.id.rvAperturas)
        rvAperturas.layoutManager = LinearLayoutManager(this)

        //Inicializar el ViewModel
        viewModel = ViewModelProvider(this).get(AperturaViewModel::class.java)

        //Observar los datos LD
        viewModel.aperturas.observe(this) { lista ->
            rvAperturas.adapter = AperturaAdapter(lista)
        }

        // Datos de firebase
        viewModel.cargarAperturas()
    }
}