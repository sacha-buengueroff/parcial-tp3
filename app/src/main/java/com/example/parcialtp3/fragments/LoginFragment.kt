package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.parcialtp3.R

class LoginFragment : Fragment() {

    lateinit var fragmentView : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView =  inflater.inflate(R.layout.login_fragment, container, false)

        val btnLogin = fragmentView.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {var action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            fragmentView.findNavController().navigate(action) }
        return fragmentView
    }

}