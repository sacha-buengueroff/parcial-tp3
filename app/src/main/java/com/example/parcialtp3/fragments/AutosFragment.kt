package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.viewmodel.AutosViewModel

class AutosFragment : Fragment() {
    lateinit var autosView : View
    lateinit var autosRecView : RecyclerView
    lateinit var autosViewModel : AutosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        autosView = inflater.inflate(R.layout.fragment_autos, container, false)

        autosView = ViewModelProvider(requireActivity()).get(AutosViewModel::class.java)

        return autosView
    }

}