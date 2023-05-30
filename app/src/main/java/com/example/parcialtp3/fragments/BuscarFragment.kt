package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.parcialtp3.R
import com.example.parcialtp3.utils.ToolbarUitls

class BuscarFragment : Fragment() {
    lateinit var buscarView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        buscarView = inflater.inflate(R.layout.fragment_buscar, container, false)

        var toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar_custom)
        ToolbarUitls.updateToolbarVisibility(toolbar, false)

        return buscarView
    }
}