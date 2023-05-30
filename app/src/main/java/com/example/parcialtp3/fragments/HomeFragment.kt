package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.MarcasAdapter
import com.example.parcialtp3.domain.Marca
import androidx.appcompat.widget.Toolbar
import com.example.parcialtp3.utils.ToolbarUitls


class HomeFragment : Fragment() {
    lateinit var homeView: View
    lateinit var marcasRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        homeView = inflater.inflate(R.layout.fragment_home, container, false)
        marcasRecView = homeView.findViewById<RecyclerView>(R.id.marcasRecycleView)
        marcasRecView.setHasFixedSize(true)
        getMarcas()
        var toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar_custom)
        ToolbarUitls.updateToolbarVisibility(toolbar, false)
        return homeView
    }

    override fun onStart() {
        super.onStart()
    }

    private fun getMarcas() {

        val listMarcas: List<Marca> = listOf(
            Marca("Maserati", "5", "maserati"),
            Marca("Mercedes", "32", "mercedes"),
            Marca("TOGG", "8", "togg"),
            Marca("Porsche", "10", "porsche"),
            Marca("Toyota", "3", "toyota"),
            Marca("BMW", "25", "bmw")
        )
        marcasRecView.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = MarcasAdapter(listMarcas)
        }
    }
}