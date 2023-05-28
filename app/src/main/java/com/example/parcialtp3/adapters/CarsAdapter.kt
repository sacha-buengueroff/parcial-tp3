package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.model.domain.Car

class   CarsAdapter (private val carList: List<Car>): RecyclerView.Adapter<CarsAdapter.CarViewHolder>(){

    //TODO ver como carajo hacer para usar los beneficios de la observabilidad que da el MutableLiveData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.fragment_car_view_item,parent,false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        //TODO completar el resto de setters
        holder.setCarClass(car.carClass)
        holder.setFuelType(car.fuelType)
    }

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

}