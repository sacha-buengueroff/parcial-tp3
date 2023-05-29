package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.parcialtp3.R
import com.example.parcialtp3.utils.ToolbarUitls


class HomeFragment : Fragment() {
    lateinit var homeView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeView = inflater.inflate(R.layout.fragment_home, container, false)
        var toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar_custom)
        ToolbarUitls.updateToolbarVisibility(toolbar, false)

        return homeView
    }

    override fun onStart() {
        super.onStart()
    }
}