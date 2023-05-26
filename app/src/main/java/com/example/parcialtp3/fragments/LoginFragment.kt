package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        //Oculto el menu hamburguesa del login
        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.hide()

        //Me traigo el nombre TODO: pasarlo a View Model(con funcionalidad que requira un mail y user)
        val txtUserName = fragmentView.findViewById<TextView>(R.id.txt_UserName)
        val userName = txtUserName.text.toString()


        val btnLogin = fragmentView.findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            var action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(userName)
            fragmentView.findNavController().navigate(action)
        }


        return fragmentView
    }

}