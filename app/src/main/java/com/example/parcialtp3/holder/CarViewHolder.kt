package com.example.parcialtp3.holder

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import java.lang.Exception
import java.util.Locale

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
        val imgMake = vista.findViewById<ImageView>(R.id.imgCarLogo)
        try {
            val drawableId = vista.resources.getIdentifier(make, "drawable", vista.context.packageName)
            imgMake.setImageResource(drawableId)
        }catch (e:Exception)
        {
          println("Imagen no disponible")
        }
    }

    fun setModel(model: String) {
        val txtClass = vista.findViewById<TextView>(R.id.txtCarModel)
        txtClass.text = model.replaceFirstChar(Char::titlecase)
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

