package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.viewmodel.LoginViewModel


class ProfileFragment : Fragment() {

    lateinit var profileView : View
    lateinit var profileName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        profileView = inflater.inflate(R.layout.fragment_profile, container, false)

        profileName = profileView.findViewById<TextView>(R.id.txt_profileName)

        return profileView
    }

    override fun onStart() {
        super.onStart()

        var loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        loginViewModel.userName.observe(viewLifecycleOwner) { result ->
            profileName.text = result.toString()
        }

    }

}