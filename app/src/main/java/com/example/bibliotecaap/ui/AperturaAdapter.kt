package com.example.bibliotecaap.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliotecaap.data.Apertura
import com.example.bibliotecaap.R

class AperturaAdapter(private val lista: List<Apertura>) : RecyclerView.Adapter<AperturaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvMovimientos: TextView = view.findViewById(R.id.tvMovimientos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_apertura, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val apertura = lista[position]
        holder.tvNombre.text = apertura.nombre
        holder.tvMovimientos.text = apertura.movimientos

        //Click en tarjetitas
        holder.itemView.setOnClickListener {
            val contexto = holder.itemView.context
            val intent = Intent(contexto, DetalleActivity::class.java)

            // Datos de la sigueinte pantalla
            intent.putExtra("nombre", apertura.nombre)
            intent.putExtra("movimientos", apertura.movimientos)
            intent.putExtra("descripcion", apertura.descripcion)
            intent.putExtra("eco", apertura.eco)

            contexto.startActivity(intent)
        }
    }

    override fun getItemCount() = lista.size
}