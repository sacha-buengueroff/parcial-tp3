package com.example.parcialtp3.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R

class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var vista: View

    init {
        this.vista = itemView
    }

    fun setCarClass(carClass: String) {
        val txtClass = vista.findViewById<TextView>(R.id.carClass)
        txtClass.text = carClass
    }
    fun setFuelType(carClass: String) {
        val txtClass = vista.findViewById<TextView>(R.id.fuelType)
        txtClass.text = carClass
    }
    fun setMake(carClass: String) {

    }fun setModel(carClass: String) {

    }
    fun settransmission(carClass: String) {

    }
    fun setYear(carClass: String) {

    }

}

