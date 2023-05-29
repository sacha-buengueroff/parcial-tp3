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
        val txtClass = vista.findViewById<TextView>(R.id.txtClass)
        txtClass.text = carClass
    }
    fun setFuelType(fuelType: String) {
        val txtClass = vista.findViewById<TextView>(R.id.txtFuelType)
        txtClass.text = fuelType
    }
    fun setMakeImage(make: String) {

    }
    fun setModel(model: String) {
        val txtClass = vista.findViewById<TextView>(R.id.txtCarModel)
        txtClass.text = model
    }
    fun settransmission(transmission: String) {
        val txtClass = vista.findViewById<TextView>(R.id.txtTransmission)
        txtClass.text = if (transmission == "a") "Automático" else "Manual"
    }
    fun setYear(year: String) {
        val txtClass = vista.findViewById<TextView>(R.id.txtYear)
        txtClass.text = year
    }

}

