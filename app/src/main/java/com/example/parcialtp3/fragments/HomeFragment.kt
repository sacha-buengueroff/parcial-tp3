package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.MarcasAdapter
import com.example.parcialtp3.domain.Marca


class HomeFragment : Fragment() {
    lateinit var homeView: View
    lateinit var marcasRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeView = inflater.inflate(R.layout.fragment_home, container, false)
        marcasRecView = homeView.findViewById<RecyclerView>(R.id.marcasRecycleView)
        marcasRecView.setHasFixedSize(true)
        getMarcas()
        return homeView
    }

    override fun onStart() {
        super.onStart()
    }

    private fun getMarcas() {

        val listMarcas: List<Marca> = listOf(
            Marca("Maserati","5", "maserati.png"),
            Marca("Mercedes", "32", "mercedes.png"),
            Marca("TOGG", "8", "togg.png"),
            Marca("Porsche", "10", "porsche.png"),
            Marca("Toyota", "3", "toyota.png"),
            Marca("BMW", "25", "bmw.png")
        )
        marcasRecView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MarcasAdapter(listMarcas)
        }
    }


}