package com.example.parcialtp3.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import java.lang.Exception

class MarcaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var vista: View

    init {
        this.vista = itemView
    }

    fun setMarca(marcaClass: String) {
        val txtMarca = vista.findViewById<TextView>(R.id.txtMarca)
        txtMarca.text = marcaClass
    }

    fun setAmount(amount: String) {
        val txtAmount = vista.findViewById<TextView>(R.id.txtAmount)
        txtAmount.text = amount
    }

    fun setMakeImage(make: String) {
        val imgMake = vista.findViewById<ImageView>(R.id.imgMarcaLogo)
        try {
            val drawableId = vista.resources.getIdentifier(make, "drawable", vista.context.packageName)
            imgMake.setImageResource(drawableId)
        }catch (e: Exception)
        {
            println("Imagen no disponible")
        }
    }

}