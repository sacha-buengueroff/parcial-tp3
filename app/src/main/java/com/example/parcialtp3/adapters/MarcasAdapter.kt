package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.domain.Marca
import com.example.parcialtp3.holder.MarcaViewHolder

class MarcasAdapter(private val marcaList: List<Marca>): RecyclerView.Adapter<MarcaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarcaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_marca_view_item, parent, false)
        return MarcaViewHolder(view)
    }

    override fun getItemCount(): Int = marcaList.size

    override fun onBindViewHolder(holder: MarcaViewHolder, position: Int) {
        val marca = marcaList[position]
        holder.setMarca(marca.marca)
        holder.setAmount(marca.amount.toString())
        holder.setMakeImage(marca.make)
    }

}