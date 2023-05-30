package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.holder.CarViewHolder
import com.example.parcialtp3.domain.Car

class CarsAdapter(private val carList: List<Car>) : RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_car_view_item, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.setCarClass(car.carClass)
        holder.setFuelType(car.fuelType)
        holder.settransmission(car.transmission)
        holder.setCarClass(car.carClass)
        holder.setModel(car.model)
        holder.setYear(car.year.toString())
        holder.setMakeImage(car.make)
    }
}